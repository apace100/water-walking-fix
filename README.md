# Water Walking Fix

## What this mod is
In vanilla, the only sources of an entity being able to walk on fluid is the Strider, which is able to walk on lava.
Vanilla's implementation however is theoretically general, with a method on entities which can be overridden to allow the entity to walk on any fluid.

Mods exist which use this method, for example to allow players to walk on water, e.g. with a new enchantment or by picking a specific origin.

Because vanilla's implementation doesn't consider walking on water as a possibility, the following bugs exist:
* Entities which can walk on a fluid are only able to walk on source blocks, not flowing instances of the fluid
* Entities which can walk on a fluid are not able to walk on fluidlogged blocks

This mod fixes those two issues.

## What this mod is not

The mod does not add any way to allow players or other entities to walk on water.
It merely exists to fix the issues present in vanilla when water walking is enabled by another mod.