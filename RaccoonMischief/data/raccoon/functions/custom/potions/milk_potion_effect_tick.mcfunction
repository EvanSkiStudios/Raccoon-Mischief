#converts thrown potion to milk potion
data merge entity @e[type=potion,limit=1,nbt={Item:{tag:{milk_potion:1b}}}] {Tags:["milk"],Item:{id:"minecraft:splash_potion",Count:1b,tag:{CustomPotionColor:16777215,Enchantments:[{}],CustomModelData:1}}}

#creates area effect cloud
execute as @e[type=potion,tag=milk] as @s at @s run execute unless block ~ ~-0.5 ~ air run summon area_effect_cloud ~ ~ ~ {Particle:"entity_effect",Radius:5f,Duration:100,Color:16777215,Tags:["milk"]}

#checks to see if player is in splash zone
execute as @a at @s positioned ~-0.5 ~ ~-0.5 if entity @e[type=minecraft:area_effect_cloud, dx=0, dy=0, dz=0,tag=milk] run effect clear @s

#checks to see if entity is in splash zone
execute as @e at @s positioned ~-0.5 ~ ~-0.5 if entity @e[type=minecraft:area_effect_cloud, dx=0, dy=0, dz=0,tag=milk] run effect clear @s