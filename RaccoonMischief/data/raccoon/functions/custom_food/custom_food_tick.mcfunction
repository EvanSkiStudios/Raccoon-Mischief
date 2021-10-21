######## CUSTOM FOOD TEMPLATE ########
######## Made by Timber Forge https://youtu.be/TtdHB984DDc########

######## Example Food 
scoreboard players set @a[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{nutriant_dirt:1b}}}] ndirt_delay 2


#### Run command for effect or any other command or function file if player eats custon item
#### (If the player has recently held the custom item and also just ate the base item)
#execute as @a[scores={spinach_delay=1..,berry_eat=1}] at @s run say IM STRONG TO THE FINICH 'CAUSE I EATS ME SPINACH
#execute as @a[scores={spinach_delay=1..,berry_eat=1}] at @s run effect give @s minecraft:strength 10 10

#### Reset eat scoreboard
scoreboard players reset @a[scores={ndirt_eat=1..}] ndirt_eat

#### Constantly remove 1 from the delay
execute as @a[scores={ndirt_delay=1..}] unless entity @s[nbt={SelectedItem:{id:"minecraft:baked_potato",tag:{ndirt_eat:1b}}}] run scoreboard players remove @s ndirt_delay 1