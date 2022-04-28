######## CUSTOM FOOD TEMPLATE ########
######## Made by Timber Forge https://youtu.be/TtdHB984DDc########

######## Example Food 
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{rm_nutriant_dirt:1b}}}] rm_ndirt_delay 2
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{netherwarp_eat:1b}}}] rm_netherwarp_delay 2

scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:honey_bottle",tag:{rm_cup_of_lava:1b}}}] rm_lava_cup_delay 2


#### Run command for effect or any other command or function file if player eats custon item
#### (If the player has recently held the custom item and also just ate the base item)
execute as @a[scores={rm_lava_cup_delay=2..,rm_lava_cup_eat=2}] at @s run function raccoon:custom/food/effects/cf_bottle_of_lava_effect

execute as @a[scores={rm_netherwarp_delay=2..,rm_netherwarp_eat=1}] as @s run function raccoon:custom/food/effects/cf_netherwarp_effect

#### Reset eat scoreboard
scoreboard players reset @a[scores={rm_ndirt_eat=1..}] rm_ndirt_eat
scoreboard players reset @a[scores={rm_netherwarp_eat=1..}] rm_netherwarp_eat
scoreboard players reset @a[scores={rm_lava_cup_eat=1..}] rm_lava_cup_eat

#### Constantly remove 1 from the delay
execute as @a[scores={rm_ndirt_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{rm_ndirt_eat:1b}}}] run scoreboard players remove @s rm_ndirt_delay 1

execute as @a[scores={rm_netherwarp_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{rm_netherwarp_eat:1b}}}] run scoreboard players remove @s rm_netherwarp_delay 1

execute as @a[scores={rm_lava_cup_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:honey_bottle",tag:{rm_cup_of_lava:1b}}}] run scoreboard players remove @s rm_lava_cup_delay 1