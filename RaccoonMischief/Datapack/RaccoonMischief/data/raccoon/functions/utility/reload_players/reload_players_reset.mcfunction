#sneak flag
scoreboard players add @s rm_player_is_sneaking 0
scoreboard players add @s rm_player_is_jumping 0

scoreboard players add @s rm_barrel_hat 0
scoreboard players add @s rm_barrel_hat_sneak 0
scoreboard players add @s rm_barrel_hat_jump 0

#triggers
scoreboard players enable @s rm_ver
scoreboard players set @s rm_ver 0

scoreboard players enable @s rm_ui_therm
scoreboard players set @s rm_ui_therm 0

#add players to scoreboards
scoreboard players add @s rm_deathDetect 0
scoreboard players add @s rm_llamaDetect 0
scoreboard players add @s rm_eatCake 0



#custom effects
execute as @a[tag=levitate] run execute as @s at @s run tag @s remove levitate

tellraw @s [{"text": "RaccoonMischief V.2.0 has finished setup for ", "color": "#00FF44"},{"selector":"@s", "color": "#00FF44"}]
advancement grant @s only raccoon:chaos/root

#set their scoreboard to 1 to tell the game they have been reset
scoreboard players set @a[scores={rm_setup_players=..0}] rm_setup_players 1