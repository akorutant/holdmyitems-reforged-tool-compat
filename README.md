# Hold My Items Reforged: Silent Gear & modded tools fix

[![Minecraft 1.21.1](https://img.shields.io/badge/Minecraft-1.21.1-62b47a)](https://www.minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1-orange)](https://neoforged.net/)
[![Fabric](https://img.shields.io/badge/Fabric-1.21.1-d8c49a)](https://fabricmc.net/)
[![Hold My Items Reforged](https://img.shields.io/badge/Hold_My_Items-Reforged-blue)](https://www.curseforge.com/minecraft/mc-mods/hold-my-items-reforged)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Source-based compatibility release of **Hold My Items - Reforged for Minecraft 1.21.1**, available for NeoForge and Fabric.

**Download on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/silent-gear-tool-compatibility)** | [Source code and GitHub releases](https://github.com/akorutant/holdmyitems-reforged-tool-compat)

Version 2.2.0 is a normal mod built from source. It fixes inspection and rendering for modded tools, including **Silent Gear tools and Create Wrench**, without patching another JAR.

If a Silent Gear tool is held at the wrong angle, misses the visible-hand animation, or behaves differently from a vanilla tool in first person, this patch targets that issue.

## Screenshots

The patch makes Silent Gear tools use the same first-person hand positioning and animations as vanilla tools.

| Vanilla pickaxe | Silent Gear before the fix | Silent Gear after the fix |
|---|---|---|
| ![Vanilla pickaxe](docs/screenshots/vanilla-pickaxe-reference.png) | ![Broken Silent Gear pickaxe](docs/screenshots/silent-gear-broken.png) | ![Fixed Silent Gear pickaxe](docs/screenshots/silent-gear-fixed.png) |

## Install version 2.2.0

No terminal is required:

1. Download `holdmyitemsnf-1.21.1-v2.2.0-source-compat.jar` from [GitHub Releases](https://github.com/akorutant/holdmyitems-reforged-tool-compat/releases/tag/v2.2.0) or [CurseForge](https://www.curseforge.com/minecraft/mc-mods/silent-gear-tool-compatibility).
2. Open the `minecraft/mods` folder for your launcher instance.
3. Remove the original `holdmyitemsnf-1.21.1v2.1.jar` and any older compatibility test JARs.
4. Put the downloaded 2.2.0 JAR into `minecraft/mods`.
5. Restart Minecraft completely.

Do not install this release together with the original Hold My Items Reforged JAR. This release replaces it.

## What changed

- inspection supports the NeoForge `c:tools` tag and modded weapons;
- Create Wrench is supported explicitly;
- tagged tools no longer need to be enchantable;
- the outdated special Create Wrench transform was removed, so its handle stays anchored in the character's hand;
- the inspection key has English and Russian names and uses `J` by default.

The loader projects are in [`neoforge-1.21.1`](neoforge-1.21.1) and [`fabric-1.21.1`](fabric-1.21.1). The Fabric build requires Fabric API and uses `config/holdmyitemsnf-fabric.json` for client settings.

## Legacy patcher

The original bytecode patcher remains in this repository for users of the older 2.1 patched build:

1. Download `holdmyitems-reforged-tool-compat-patcher-1.0.0.jar` from the [latest release](../../releases/latest).
2. Put it next to a clean `holdmyitemsnf-1.21.1v2.1.jar` backup.
3. Open a terminal in that folder and run:

   ```shell
   java -jar holdmyitems-reforged-tool-compat-patcher-1.0.0.jar \
     holdmyitemsnf-1.21.1v2.1.jar \
     holdmyitemsnf-1.21.1v2.1-patched.jar
   ```

4. Move the patched JAR into `minecraft/mods` and remove the unpatched copy from that folder.
5. Restart Minecraft completely.

> Always keep the original HoldMyItems JAR as a backup. Java 21 is required.

## Root cause

The 1.21.1 NeoForge build checks the legacy `forge:tools` item tag. NeoForge 1.21 uses the common `c:tools` tag, which includes vanilla tools and tool categories registered by other mods. The renderer also requires tagged tools to report themselves as enchantable, which excludes some modular tools.

The source release:

1. changes the internal tool tag from `forge:tools` to `c:tools`;
2. removes the redundant enchantability gate after an item has already matched the tool tag;
3. broadens inspection to modded weapons and Create Wrench;
4. removes the obsolete Create-specific wrench pose that no longer matches current Create rendering.

## Building

Build the normal mod with Java 21:

```shell
cd neoforge-1.21.1
./gradlew build
```

The mod is written to `neoforge-1.21.1/build/libs/holdmyitemsnf-2.2.0-compat.jar`.

Build the Fabric version with Java 21:

```shell
cd fabric-1.21.1
./gradlew build
```

The Fabric mod is written to `fabric-1.21.1/build/libs/holdmyitems-fabric-1.21.1-2.2.0-compat-fabric.jar`.

The legacy patcher can still be built with `mvn package` from the repository root.

## Compatibility

Validated with:

- Minecraft 1.21.1
- NeoForge 21.1.243
- Fabric Loader 0.19.5 and Fabric API 0.116.17+1.21.1
- Silent Gear 4.2.1.1
- Create 6.0.10

The release is client-side and replaces Hold My Items - Reforged 2.1.

## Search keywords

Hold My Items Reforged fix, HoldMyItems Silent Gear compatibility, Silent Gear first-person animation, modded tools rendering fix, Minecraft 1.21.1 NeoForge tool animation.

## Attribution

Hold My Items - Reforged is created by Bene2212_ and is available on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/hold-my-items-reforged). This compatibility project is unofficial and is not affiliated with the mod author.
