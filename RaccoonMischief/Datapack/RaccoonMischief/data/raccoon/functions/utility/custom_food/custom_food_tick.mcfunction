######## CUSTOM FOOD TEMPLATE ########
######## Made by Timber Forge https://youtu.be/TtdHB984DDc########

######## Example Food 
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{rm_nutriant_dirt:1b}}}] rm_ndirt_delay 2


#### Run command for effect or any other command or function file if player eats custon item
#### (If the player has recently held the custom item and also just ate the base item)

#### Reset eat scoreboard
scoreboard players reset @a[scores={rm_ndirt_eat=1..}] rm_ndirt_eat

#### Constantly remove 1 from the delay
execute as @a[scores={rm_ndirt_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{rm_ndirt_eat:1b}}}] run scoreboard players remove @s rm_ndirt_delay 1