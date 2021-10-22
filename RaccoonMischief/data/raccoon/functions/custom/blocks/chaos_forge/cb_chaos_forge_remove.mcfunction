#play sounds
function raccoon:custom/blocks/chaos_forge/effects/cb_chaos_forge_effect_remove

#CREATE BLOCK DROP
function raccoon:custom/blocks/give/cb_give_chaos_forge

#KILL ARMOR STAND
kill @e[type=minecraft:armor_stand,tag=chaosforge,distance=0..2,sort=nearest,limit=1]

#KILL BASE BLOCK
kill @e[type=item,nbt={Item:{id:"minecraft:dropper"}},distance=0..2,sort=nearest,limit=1]

#KILL ITEM FRAME
kill @s