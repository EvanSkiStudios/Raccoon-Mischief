######## CUSTOM FOOD TEMPLATE ########
######## Made by Timber Forge https://youtu.be/TtdHB984DDc########

######## Example Food 
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{nutriant_dirt:1b}}}] ndirt_delay 2
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:honey_bottle",tag:{cup_of_lava:1b}}}] lava_cup_delay 2


#### Run command for effect or any other command or function file if player eats custon item
#### (If the player has recently held the custom item and also just ate the base item)
execute as @a[scores={lava_cup_delay=2..,lava_cup_eat=2}] at @s run function raccoon:custom/food/effects/cf_bottle_of_lava_effect


#### Reset eat scoreboard
scoreboard players reset @a[scores={ndirt_eat=1..}] ndirt_eat
scoreboard players reset @a[scores={lava_cup_eat=1..}] lava_cup_eat

#### Constantly remove 1 from the delay
execute as @a[scores={ndirt_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{ndirt_eat:1b}}}] run scoreboard players remove @s ndirt_delay 1

execute as @a[scores={lava_cup_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:honey_bottle",tag:{cup_of_lava:1b}}}] run scoreboard players remove @s lava_cup_delay 1