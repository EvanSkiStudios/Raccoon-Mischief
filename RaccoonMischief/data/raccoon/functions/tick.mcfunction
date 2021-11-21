#play sound at dead player
function raccoon:effects/death_sfx/death_detect

#mmm cake
tag @a[scores={eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={eatCake=1}] eatCake 2
tag @a[scores={eatCake=2}] remove caked

#triggers
scoreboard players enable @a RaccAdvan
execute as @a[scores={RaccAdvan=1..}] run tellraw @p {"text":"Raccoon Mischief Advancements (Click to open)","color":"green","italic":true,"hoverEvent":{"action":"show_text","contents":[{"text":"Click to open Github Page","italic":true}]},"clickEvent":{"action":"open_url","value":"https://github.com/EvanSkiStudios/Raccoon-Mischief/blob/master/Lists/Advancement_List.md"}}
scoreboard players set @a RaccAdvan 0

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