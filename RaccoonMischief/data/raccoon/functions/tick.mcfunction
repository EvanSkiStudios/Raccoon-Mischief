#play sound at dead player
function raccoon:effects/death_sfx/death_detect
function raccoon:effects/llama_death/llama_death_detect

#mmm cake
tag @a[scores={rm_eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={rm_eatCake=1}] rm_eatCake 2
tag @a[scores={rm_eatCake=2}] remove caked

#triggers
scoreboard players enable @a RMAdvan
execute as @a[scores={RMAdvan=1..}] run tellraw @s {"text":"Raccoon Mischief Advancements (Click to open)","color":"green","italic":true,"hoverEvent":{"action":"show_text","contents":[{"text":"Click to open Github Page","italic":true}]},"clickEvent":{"action":"open_url","value":"https://github.com/EvanSkiStudios/Raccoon-Mischief/blob/master/Lists/Advancement_List.md"}}
scoreboard players set @a RMAdvan 0

scoreboard players enable @a RMVer
execute as @a[scores={RMVer=1..}] run tellraw @s {"text":"Raccoon Mischief Version 1.2.1","color":"green","italic":false}
scoreboard players set @a RMVer 0

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

#custom Item Functions
function raccoon:custom/items/custom_item_tick