#play sound at dead player
tag @a[scores={deathDetect=1}] add died
playsound minecraft:custom.player.no master @a[tag=died] ~ ~ ~
scoreboard players set @a[scores={deathDetect=1}] deathDetect 0
tag @a[scores={deathDetect=0}] remove died

#mmm cake
tag @a[scores={eatCake=1}] add caked
advancement grant @a[tag=caked] only raccoon:chaos/trolls/cake
scoreboard players set @a[scores={eatCake=1}] eatCake 2
tag @a[scores={eatCake=2}] remove caked


#custom food
function raccoon:custom_food/custom_food_tick