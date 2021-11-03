tellraw @a {"text": "RaccoonMischief V.1.2 is loaded", "color": "#00FF44"}
advancement grant @a only raccoon:chaos/root

#cleanup/restart
#scoreboard
scoreboard players set @a deathDetect 0
scoreboard players set @a eatCake 0
scoreboard objectives remove deathDetect
scoreboard objectives remove eatCake
#recipes
recipe take @a leather
recipe take @a raccoon:crafting/custom/food/rcip_cf_nutrientdirt

#set up scoreboards
scoreboard objectives add deathDetect deathCount
scoreboard objectives add eatCake minecraft.custom:minecraft.eat_cake_slice

#add players to scoreboards
scoreboard players add @a deathDetect 0
scoreboard players add @a eatCake 0

#custom food
function raccoon:custom/food/custom_food_load

#custom item
function raccoon:custom/items/custom_item_load