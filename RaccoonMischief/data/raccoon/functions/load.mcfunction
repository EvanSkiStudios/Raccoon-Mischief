tellraw @a {"text": "RaccoonMischief V.1.1 is loaded", "color": "#00FF44"}
advancement grant @a only raccoon:chaos/root

#cleanup/restart
scoreboard players set @a deathDetect 0
scoreboard players set @a eatCake 0
scoreboard objectives remove deathDetect
scoreboard objectives remove eatCake

#set up scoreboards
scoreboard objectives add deathDetect deathCount
scoreboard objectives add eatCake minecraft.custom:minecraft.eat_cake_slice

#add players to scoreboards
scoreboard players add @a deathDetect 0
scoreboard players add @a eatCake 0
