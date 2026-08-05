package io.github.akorutant.hmi;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class Patcher {
    private static final String TAGS_CLASS =
            "de/bene2212/holdmyitemsnf/util/HoldMyItemsTags.class";
    private static final String RENDERER_CLASS =
            "de/bene2212/holdmyitemsnf/mixin/HeldItemsMixin.class";
    private Patcher() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java -jar patcher.jar <input.jar> <output.jar>");
            System.exit(2);
        }

        Path input = Path.of(args[0]).toAbsolutePath();
        Path output = Path.of(args[1]).toAbsolutePath();
        if (!Files.isRegularFile(input)) {
            throw new IOException("Input JAR does not exist: " + input);
        }

        Path parent = output.getParent();
        if (parent != null) Files.createDirectories(parent);
        Path temporary = Files.createTempFile(parent, "hmi-patched-", ".jar");
        Set<String> patchedEntries = new HashSet<>();

        try (InputStream fileIn = Files.newInputStream(input);
             ZipInputStream zipIn = new ZipInputStream(fileIn);
             OutputStream fileOut = Files.newOutputStream(temporary);
             ZipOutputStream zipOut = new ZipOutputStream(fileOut)) {
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                byte[] data = zipIn.readAllBytes();
                if (TAGS_CLASS.equals(entry.getName())) {
                    data = patchToolTag(data);
                    patchedEntries.add(TAGS_CLASS);
                } else if (RENDERER_CLASS.equals(entry.getName())) {
                    data = patchToolRecognition(data);
                    data = patchCreateWrenchPose(data);
                    patchedEntries.add(RENDERER_CLASS);
                }

                ZipEntry replacement = new ZipEntry(entry.getName());
                replacement.setTime(entry.getTime());
                replacement.setComment(entry.getComment());
                replacement.setExtra(entry.getExtra());
                zipOut.putNextEntry(replacement);
                zipOut.write(data);
                zipOut.closeEntry();
            }

        } catch (Exception error) {
            Files.deleteIfExists(temporary);
            throw error;
        }

        if (!patchedEntries.equals(Set.of(TAGS_CLASS, RENDERER_CLASS))) {
            Files.deleteIfExists(temporary);
            throw new IOException("Unsupported HoldMyItems JAR: expected classes were not found");
        }

        Files.move(temporary, output, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Patched HoldMyItems tool compatibility: " + output);
    }

    private static byte[] patchToolTag(byte[] input) {
        ClassNode classNode = readClass(input);
        int changed = 0;
        for (MethodNode method : classNode.methods) {
            if (!"<clinit>".equals(method.name)) continue;
            for (AbstractInsnNode instruction = method.instructions.getFirst();
                 instruction != null;
                 instruction = instruction.getNext()) {
                if (!(instruction instanceof LdcInsnNode namespace)
                        || !"forge".equals(namespace.cst)) continue;
                AbstractInsnNode next = instruction.getNext();
                while (next != null && next.getOpcode() < 0) next = next.getNext();
                if (next instanceof LdcInsnNode path && "tools".equals(path.cst)) {
                    namespace.cst = "c";
                    changed++;
                }
            }
        }
        if (changed != 1) {
            throw new IllegalStateException("Expected one forge:tools reference, changed " + changed);
        }
        return writeClass(classNode);
    }

    private static byte[] patchToolRecognition(byte[] input) {
        ClassNode classNode = readClass(input);
        int changed = 0;
        for (MethodNode method : classNode.methods) {
            if (!"onRenderArmWithItem".equals(method.name)) continue;
            for (AbstractInsnNode instruction = method.instructions.getFirst();
                 instruction != null; ) {
                AbstractInsnNode next = instruction.getNext();
                if (instruction instanceof MethodInsnNode call
                        && "net/minecraft/world/item/ItemStack".equals(call.owner)
                        && "isEnchantable".equals(call.name)
                        && "()Z".equals(call.desc)) {
                    InsnList replacement = new InsnList();
                    replacement.add(new InsnNode(Opcodes.POP));
                    replacement.add(new InsnNode(Opcodes.ICONST_1));
                    method.instructions.insertBefore(instruction, replacement);
                    method.instructions.remove(instruction);
                    changed++;
                }
                instruction = next;
            }
        }
        if (changed != 3) {
            throw new IllegalStateException("Expected three tool enchantability checks, changed " + changed);
        }
        return writeClass(classNode);
    }

    private static byte[] patchCreateWrenchPose(byte[] input) {
        ClassNode classNode = readClass(input);
        int changed = 0;
        for (MethodNode method : classNode.methods) {
            if (!"onRenderArmWithItem".equals(method.name)) continue;
            for (AbstractInsnNode instruction = method.instructions.getFirst();
                 instruction != null;
                 instruction = instruction.getNext()) {
                if (!(instruction instanceof LdcInsnNode text)
                        || !"wrench".equals(text.cst)) continue;
                text.cst = "wrench_hmi_default_pose";
                changed++;
            }
        }
        if (changed != 1) {
            throw new IllegalStateException("Expected one Create wrench special-case, changed " + changed);
        }
        return writeClass(classNode);
    }

    private static ClassNode readClass(byte[] input) {
        ClassNode classNode = new ClassNode();
        new ClassReader(input).accept(classNode, 0);
        return classNode;
    }

    private static byte[] writeClass(ClassNode classNode) {
        ClassWriter writer = new ClassWriter(0);
        classNode.accept(writer);
        return writer.toByteArray();
    }
}
