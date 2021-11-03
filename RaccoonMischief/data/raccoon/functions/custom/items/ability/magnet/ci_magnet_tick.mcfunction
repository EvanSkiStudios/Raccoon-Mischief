#if player is holding a magnet
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:iron_nugget",tag:{magnet:1b}}}] holding_magnet 2

#run item function when holding
execute as @a[scores={holding_magnet=2..}] at @s run function raccoon:custom/items/ability/magnet/ci_magnet_ability

#### Constantly remove 1 from the delay
execute as @a[scores={holding_magnet=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:iron_nugget",tag:{magnet:1b}}}] run scoreboard players remove @s holding_magnet 1