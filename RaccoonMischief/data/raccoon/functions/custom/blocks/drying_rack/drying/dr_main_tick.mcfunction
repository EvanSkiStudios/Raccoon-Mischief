#locate armor stand that is a drying rack holding a correct item

#if empty gets raw hide
execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=!drying_rawhide,nbt={HandItems:[{id:"minecraft:beetroot_seeds",Count:1b,tag:{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}},{}]}] at @s run function raccoon:custom/blocks/drying_rack/drying/dr_dry_rawhide


#if raw hide gets taken
execute as @e[type=minecraft:armor_stand,tag=dryingrack,tag=drying_rawhide,nbt=!{HandItems:[{id:"minecraft:beetroot_seeds",Count:1b,tag:{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}},{}]}] at @s run function raccoon:custom/blocks/drying_rack/drying/dr_dry_take_rawhide

