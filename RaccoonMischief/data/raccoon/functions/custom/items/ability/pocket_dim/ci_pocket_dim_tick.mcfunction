#if player is holding a magnet
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:carrot_on_a_stick",tag:{pocket_dim:1b}}}] holding_p_dim 2
#scoreboard players set @a[nbt={Inventory:[{Slot: -106b, id:"minecraft:carrot_on_a_stick",tag:{pocket_dim:1b} }]}] holding_p_dim 2

#run item function when holding
execute as @a[scores={holding_p_dim=2..}] at @s run function raccoon:custom/items/ability/pocket_dim/ci_pocket_dim_ability

#### Constantly remove 1 from the delay
execute as @a[scores={holding_p_dim=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:carrot_on_a_stick",tag:{pocket_dim:1b}}}] run scoreboard players remove @s holding_p_dim 1

#cleanup minecart when done
execute as @a[scores={holding_p_dim=1}] at @s run function raccoon:custom/items/ability/pocket_dim/ci_pocket_dim_ability_cleanup