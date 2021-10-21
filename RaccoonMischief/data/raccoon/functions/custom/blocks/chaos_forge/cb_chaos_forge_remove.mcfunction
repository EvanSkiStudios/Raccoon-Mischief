#CREATE BLOCK DROP
summon item ~ ~0.5 ~ {Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:7777,EntityTag:{Silent:1b,Tags:["chaosforge"],Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:7777}},Invulnerable:1b,Invisible:1b,Fixed:1b}}}}

#KILL BASE BLOCK
kill @e[type=item,nbt={Item:{id:"minecraft:dropper"}},distance=0..2,sort=nearest,limit=1]

#KILL ITEM FRAME
kill @s