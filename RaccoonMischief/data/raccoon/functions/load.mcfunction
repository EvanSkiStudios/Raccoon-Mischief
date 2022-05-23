tellraw @a {"text": "RaccoonMischief V.5.13.22 is loaded", "color": "#00FF44"}
advancement grant @a only raccoon:chaos/root

#cleanup/restart

#sneak flag
scoreboard objectives remove rm_player_is_sneaking
scoreboard objectives add rm_player_is_sneaking minecraft.custom:minecraft.sneak_time
scoreboard players add @a rm_player_is_sneaking 0

scoreboard objectives remove rm_player_is_jumping
scoreboard objectives add rm_player_is_jumping minecraft.custom:minecraft.jump
scoreboard players add @a rm_player_is_jumping 0


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
scoreboard players enable @a rm_ver
scoreboard players set @a rm_ver 0

scoreboard objectives add rm_ui_therm trigger
scoreboard players enable @a rm_ui_therm
scoreboard players set @a rm_ui_therm 0

#add players to scoreboards
scoreboard players add @a rm_deathDetect 0
scoreboard players add @a rm_llamaDetect 0
scoreboard players add @a rm_eatCake 0

#custom food
function raccoon:custom/food/custom_food_load

#custom item
function raccoon:custom/items/custom_item_load

#custom effects
function raccoon:effects/mob_effects/mob_effect_load

#reward recipes
function raccoon:utility/take_recipes
function raccoon:utility/give_recipes