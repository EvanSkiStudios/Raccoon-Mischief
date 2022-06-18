#sneak flag
scoreboard players add @s rm_player_is_sneaking 0
scoreboard players add @s rm_player_is_jumping 0

#triggers
scoreboard players enable @s rm_ver
scoreboard players set @s rm_ver 0

scoreboard players enable @s rm_ui_therm
scoreboard players set @s rm_ui_therm 0

#add players to scoreboards
scoreboard players add @s rm_deathDetect 0
scoreboard players add @s rm_llamaDetect 0
scoreboard players add @s rm_eatCake 0

#custom food
function raccoon:reload_players/scoreboard_reset_values/rp_custom_food_load_reset

#custom item
function raccoon:reload_players/scoreboard_reset_values/rp_custom_item_load_reset

#custom effects
function raccoon:reload_players/scoreboard_reset_values/rp_mob_effects_load_reset
execute as @a[tag=levitate] run execute as @s at @s run tag @s remove levitate

#reward recipes
function raccoon:reload_players/scoreboard_reset_values/rp_take_recipes_reset
function raccoon:reload_players/scoreboard_reset_values/rp_give_recipes_reset

#revoke utility advancmetes
function raccoon:reload_players/scoreboard_reset_values/rp_advancement_reset

tellraw @s [{"text": "RaccoonMischief V.6.18.22 has finished setup for ", "color": "#00FF44"},{"selector":"@s", "color": "#00FF44"}]
advancement grant @s only raccoon:chaos/root

#set their scoreboard to 1 to tell the game they have been reset
scoreboard players set @a[scores={rm_setup_players=..0}] rm_setup_players 1