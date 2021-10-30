#play sound at dead player
function raccoon:effects/death_detect

#mmm cake
tag @a[scores={eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={eatCake=1}] eatCake 2
tag @a[scores={eatCake=2}] remove caked


#custom food
function raccoon:custom/food/custom_food_tick

#custom crafting
execute as @e[tag=chaosforge] at @s run function raccoon:custom/crafting/chaos_forge/chaosforge_crafting_tick

#custom Floor crafting
function raccoon:custom/crafting/floor/chaos_forge/fc_ritual_chaosforge

#custom blocks
function raccoon:custom/blocks/cb_main

#custom block function
function raccoon:custom/blocks/drying_rack/drying/dr_main_tick