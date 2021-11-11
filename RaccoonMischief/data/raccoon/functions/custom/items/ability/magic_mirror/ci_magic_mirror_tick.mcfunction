#if player is holding a MM
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:shield",tag:{mmirror:1b}}}] holding_mmirror 2
scoreboard players set @a[nbt={Inventory:[{Slot: -106b, id:"minecraft:shield",tag:{mmirror:1b} }]}] holding_mmirror 2

#run item function when holding
execute as @a[scores={holding_mmirror=2..}] at @s run function raccoon:custom/items/ability/magic_mirror/ci_magic_mirror_ability

#### Constantly remove 1 from the delay
execute as @a[scores={holding_mmirror=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:shield",tag:{mmirror:1b}}}] run scoreboard players remove @s holding_mmirror 1

# break shield when scoreboard hits 100
execute as @a[scores={MagicMirrorDam=100..}] at @s run function raccoon:custom/items/ability/magic_mirror/ci_magic_mirror_break

#if you die damage resets
#raccoon:effects/death_sfx/death_detect