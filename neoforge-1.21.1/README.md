# Hold My Items Reforged Tool Compatibility

Source-based NeoForge 1.21.1 fork of Hold My Items Reforged with improved modded-tool compatibility.

## Changes

- Uses the NeoForge common `c:tools` item tag instead of the legacy `forge:tools` tag.
- Does not require tagged tools to be enchantable.
- The inspect key works with `c:tools`, modded weapons, hoes, and `create:wrench`.
- Removes the outdated Create Wrench pose override so Create's own item renderer uses the normal hand anchor.
- Adds English and Russian names for the inspect key (default: `J`).

## Compatibility

- Minecraft 1.21.1
- NeoForge 21.1.243 or newer
- Client side only
- Tested to start with Java 21

This JAR replaces Hold My Items Reforged. Do not install both at the same time.

## Building

```shell
./gradlew build
```

The output is written to `build/libs/holdmyitemsnf-2.2.0-compat.jar`.

## Source provenance

The NeoForge port did not publish a source repository. These sources were recovered from the MIT-licensed
`holdmyitemsnf-1.21.1v2.1.jar` and placed into a standard NeoForge ModDevGradle project. The original port is
credited to bene2212 and the original Hold My Items mod to thesapling.
