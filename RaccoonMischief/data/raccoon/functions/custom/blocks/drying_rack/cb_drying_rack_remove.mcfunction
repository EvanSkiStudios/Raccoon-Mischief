#play sounds
function raccoon:custom/blocks/drying_rack/effects/cb_drying_rack_effect_remove

#CREATE BLOCK DROP
function raccoon:custom/blocks/give/cb_give_drying_rack

#KILL ARMOR STAND
kill @e[type=item,nbt={Item:{id:"minecraft:armor_stand",Count:1b}},distance=0..1,sort=nearest,limit=1]
kill @e[type=minecraft:armor_stand,tag=dryingrack_marker,distance=0..2,sort=nearest,limit=1]

#KILL ITEM FRAME
kill @s