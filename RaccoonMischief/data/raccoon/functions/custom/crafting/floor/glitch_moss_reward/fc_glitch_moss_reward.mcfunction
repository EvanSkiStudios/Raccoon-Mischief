loot spawn ~ ~1 ~ loot raccoon:glitch_moss_rewards_gen

#effects
execute at @s run particle minecraft:cloud ~ ~ ~ 1 1 1 0.2 10
execute at @s run particle minecraft:glow ~ ~ ~ 1 1 1 7 20

#sounds
execute as @s at @s run playsound minecraft:custom.crafting.loz_tada player @a ~ ~ ~

#kill items
execute as @s run kill @e[type=item,nbt={Item:{id:"minecraft:moss_block"}},distance=..1]
#kill self
kill @s