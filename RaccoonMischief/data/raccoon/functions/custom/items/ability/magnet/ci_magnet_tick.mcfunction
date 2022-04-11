#if player is holding a magnet
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:iron_nugget",tag:{magnet:1b}}}] rm_holding_magnet 2
scoreboard players set @a[nbt={Inventory:[{Slot: -106b, id:"minecraft:iron_nugget",tag:{magnet:1b} }]}] rm_holding_magnet 2

#run item function when holding
execute as @a[scores={rm_holding_magnet=2..}] at @s run function raccoon:custom/items/ability/magnet/ci_magnet_ability

#### Constantly remove 1 from the delay
execute as @a[scores={rm_holding_magnet=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:iron_nugget",tag:{magnet:1b}}}] run scoreboard players remove @s rm_holding_magnet 1