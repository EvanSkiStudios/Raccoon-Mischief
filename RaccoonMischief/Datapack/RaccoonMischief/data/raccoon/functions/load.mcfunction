tellraw @a {"text": "RaccoonMischief V.2.0 is loaded", "color": "#00FF44"}
advancement grant @a only raccoon:chaos/root

#cleanup/restart
#sneak flag
scoreboard objectives add rm_player_is_sneaking minecraft.custom:minecraft.sneak_time
scoreboard players add @a rm_player_is_sneaking 0

scoreboard objectives add rm_player_is_jumping minecraft.custom:minecraft.jump
scoreboard players add @a rm_player_is_jumping 0

#randomness
scoreboard objectives add rm_RANDOM dummy

#recipes
recipe take @a raccoon:crafting/custom/food/rcip_cf_nutrientdirt

#set up scoreboards
scoreboard objectives add rm_deathDetect deathCount
scoreboard objectives add rm_llamaDetect minecraft.killed_by:llama
scoreboard objectives add rm_eatCake minecraft.custom:minecraft.eat_cake_slice
scoreboard objectives add rm_deathcount deathCount

scoreboard objectives add rm_barrel_hat dummy
scoreboard objectives add rm_barrel_hat_sneak minecraft.custom:minecraft.sneak_time
scoreboard objectives add rm_barrel_hat_jump minecraft.custom:minecraft.jump

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

schedule function raccoon:mcfunctions/blink 5s 