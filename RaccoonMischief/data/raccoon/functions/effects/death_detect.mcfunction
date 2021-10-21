tag @a[scores={deathDetect=1}] add died
playsound minecraft:custom.player.no master @a[tag=died] ~ ~ ~
scoreboard players set @a[scores={deathDetect=1}] deathDetect 0
tag @a[scores={deathDetect=0}] remove died