#effects
playsound minecraft:entity.pig.saddle master @a ~ ~ ~ 1

#update drying rack
data merge entity @e[type=glow_item_frame,tag=dryingrack,distance=0..0.5,sort=nearest,limit=1] {Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:688200}}}

#remove drying timer
execute as @e[type=glow_item_frame,tag=dryingrack,distance=0..0.5,sort=nearest,limit=1] run tag @s remove currently_drying

kill @e[type=area_effect_cloud,tag=dryingrack,tag=drying_rawhide,distance=0..0.5,sort=nearest,limit=1]

#finish
tag @s remove drying_rawhide