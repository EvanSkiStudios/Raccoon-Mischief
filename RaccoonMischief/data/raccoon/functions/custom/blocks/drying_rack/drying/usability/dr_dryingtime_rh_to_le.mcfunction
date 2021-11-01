#effects
playsound minecraft:entity.pig.saddle master @a ~ ~ ~ 1

#update drying rack
data merge entity @e[type=glow_item_frame,tag=dryingrack,distance=0..0.5,sort=nearest,limit=1] {Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:688201}}}

#update armor stand
execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,nbt={HandItems:[{id:"minecraft:beetroot_seeds",Count:1b,tag:{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}},{}]}] at @s run data merge entity @s {HandItems:[{id:"minecraft:leather",Count:1b},{}]}

execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,nbt={HandItems:[{id:"minecraft:leather",Count:1b},{}]}] run tag @s add holding_leather

execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,tag=holding_leather,nbt={HandItems:[{id:"minecraft:leather",Count:1b},{}]}] run tag @s remove drying_rawhide

#finish
tag @s remove currently_drying