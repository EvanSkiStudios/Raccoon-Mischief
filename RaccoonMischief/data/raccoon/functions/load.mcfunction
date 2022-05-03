tellraw @a {"text": "RaccoonMischief V.4.24.22 is loaded", "color": "#00FF44"}
advancement grant @a only raccoon:chaos/root

#cleanup/restart
#scoreboard
scoreboard objectives remove rm_deathDetect
scoreboard objectives remove rm_llamaDetect
scoreboard objectives remove rm_eatCake
scoreboard objectives remove rm_holding_magnet
scoreboard objectives remove rm_holding_s_magnet
scoreboard objectives remove rm_holding_mmirror
scoreboard objectives remove rm_holding_p_dim
scoreboard objectives remove rm_lava_cup_delay
scoreboard objectives remove rm_lava_cup_eat
scoreboard objectives remove rm_MagicMirrorDam
scoreboard objectives remove rm_ndirt_delay
scoreboard objectives remove rm_ndirt_eat
scoreboard objectives remove rm_netherwarp_delay
scoreboard objectives remove rm_netherwarp_eat
scoreboard objectives remove rm_RANDOM

#randomness
scoreboard objectives add rm_RANDOM dummy

#recipes
recipe take @a raccoon:crafting/custom/food/rcip_cf_nutrientdirt
recipe take @a raccoon:crafting/custom/food/rcip_cf_netherwarp

#set up scoreboards
scoreboard objectives add rm_deathDetect deathCount
scoreboard objectives add rm_llamaDetect minecraft.killed_by:llama
scoreboard objectives add rm_eatCake minecraft.custom:minecraft.eat_cake_slice
scoreboard objectives add rm_deathcount deathCount

#triggers
scoreboard objectives add rm_ver trigger

#add players to scoreboards
scoreboard players add @a rm_deathDetect 0
scoreboard players add @a rm_llamaDetect 0
scoreboard players add @a rm_eatCake 0

#custom food
function raccoon:custom/food/custom_food_load

#custom item
function raccoon:custom/items/custom_item_load