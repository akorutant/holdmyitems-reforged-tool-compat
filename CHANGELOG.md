# Changelog

## Fabric port - 2026-09-13

- Added a client-side Fabric 1.21.1 build using official Mojang mappings.
- Ported key registration, render lifecycle timing, model initialization, and the built-in 3D bucket resource pack to Fabric API.
- Added a JSON client config at `config/holdmyitemsnf-fabric.json` with the same defaults as the NeoForge config.
- Added Fabric common tags and loader-specific fluid compatibility while sharing the main renderer between both builds.

## 2.2.0 - 2026-08-05

- Rebuilt the mod as a standard NeoForge 1.21.1 source project.
- Added inspection support for the common `c:tools` tag and modded weapons.
- Added explicit inspection support for Create Wrench.
- Removed the enchantability restriction from modded-tool rendering.
- Removed the obsolete Create Wrench pose override so the handle remains in the player's hand.
- Added English and Russian localization for the inspection key, bound to `J` by default.

This release replaces Hold My Items Reforged 2.1. Do not install both JARs together.
