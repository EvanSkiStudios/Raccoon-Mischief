summon area_effect_cloud ~ ~ ~ {Particle:"ash",NoGravity:1b,Radius:0.5f,Duration:24000,Age:1,Tags:["dryingrack","drying_rawhide"]}

#update armorstand
execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,nbt={HandItems:[{id:"minecraft:beetroot_seeds",Count:1b,tag:{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}},{}]},distance=0..0.5,sort=nearest,limit=1] run tag @s add currently_drying

#update item frame
execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,nbt={HandItems:[{id:"minecraft:beetroot_seeds",Count:1b,tag:{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}},{}]},distance=0..0.5,sort=nearest,limit=1] as @e[type=glow_item_frame,tag=dryingrack,distance=0..0.5,sort=nearest,limit=1] run tag @s add currently_drying