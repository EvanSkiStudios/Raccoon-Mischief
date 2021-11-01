#effects
playsound minecraft:entity.pig.saddle master @a ~ ~ ~ 1

#update drying rack
data merge entity @e[type=glow_item_frame,tag=dryingrack,distance=0..0.5,sort=nearest,limit=1] {Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:688202}}}

#start drying timer
function raccoon:custom/blocks/drying_rack/drying/start/dr_dryingtime_rawhide

#finish
tag @s add drying_rawhide