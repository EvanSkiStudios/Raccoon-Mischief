#play sound at dead player
function raccoon:death_effects/death_sfx/death_detect
function raccoon:death_effects/llama_death/llama_death_detect

#leviatation effect
function raccoon:effect_triggers/levitation_controller

#custom potion
function raccoon:items/milk_potion_effect_tick

#Unmercer
function raccoon:mcfunctions/unmercer

#update flags
execute as @a[scores={rm_player_is_sneaking=2..}] run scoreboard players set @s rm_player_is_sneaking 0
execute as @a[scores={rm_player_is_jumping=1..}] run scoreboard players set @s rm_player_is_sneaking 0

execute as @a[scores={rm_player_is_jumping=1..}] run scoreboard players set @s rm_player_is_jumping 0

#mmm cake
tag @a[scores={rm_eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={rm_eatCake=1}] rm_eatCake 2
tag @a[scores={rm_eatCake=2}] remove caked

#triggers
execute as @a[scores={rm_ver=1..}] run tellraw @s {"text":"RaccoonMischief V.2.0","color":"green","italic":false}
execute as @a[scores={rm_ver=1..}] run scoreboard players set @s rm_ver 0
scoreboard players enable @a rm_ver

execute as @a[scores={rm_ui_therm=2..}] run scoreboard players set @s rm_ui_therm 0
scoreboard players enable @a rm_ui_therm

#scoreboard
execute as @a[scores={rm_deathcount=100..}] run advancement grant @s only raccoon:chaos/challenges/deaths

#custom UI function
execute as @a[gamemode=!spectator,scores={rm_ui_therm=..0}] run function raccoon:ui/temp_bar