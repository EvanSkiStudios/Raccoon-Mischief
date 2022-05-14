#play sound at dead player
function raccoon:effects/death_sfx/death_detect
function raccoon:effects/llama_death/llama_death_detect

#mmm cake
tag @a[scores={rm_eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={rm_eatCake=1}] rm_eatCake 2
tag @a[scores={rm_eatCake=2}] remove caked

#triggers
execute as @a[scores={rm_ver=1..}] run tellraw @s {"text":"RaccoonMischief V.5.13.22","color":"green","italic":false}
execute as @a[scores={rm_ver=1..}] run scoreboard players set @s rm_ver 0
scoreboard players enable @a rm_ver

execute as @a[scores={rm_ui_therm=2..}] run scoreboard players set @s rm_ui_therm 0
scoreboard players enable @a rm_ui_therm

function raccoon:triggers/levitation_controller

#scoreboard
execute as @a[scores={rm_deathcount=100..}] run advancement grant @s only raccoon:chaos/challenges/deaths

#custom food
function raccoon:custom/food/custom_food_tick

#custom crafting
execute as @e[tag=chaosforge] at @s run function raccoon:custom/crafting/chaos_forge/chaosforge_crafting_tick

#custom Floor crafting
function raccoon:custom/crafting/floor/chaos_forge/fc_ritual_chaosforge

#custom blocks
function raccoon:custom/blocks/cb_main

#custom block function

#custom UI function
execute as @a[gamemode=!spectator,scores={rm_ui_therm=..0}] run function raccoon:custom/ui/temp_bar

#custom Item Functions
function raccoon:custom/items/custom_item_tick