execute as @e[type=item,nbt={Item:{id:"minecraft:diamond",Count:1b}}] at @s as @e[type=item,nbt={Item:{id:"minecraft:ender_pearl",Count:1b}},distance=0..1,limit=1,sort=nearest] at @s as @e[type=item,nbt={Item:{id:"minecraft:obsidian",Count:1b}},distance=0..1,limit=1,sort=nearest] at @s run summon item ~ ~0.1 ~ {Tags:["fresh_craft"],Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{display:{Name:'{"text":"Chaos Forge"}'},CustomModelData:7777,EntityTag:{Silent:1b,Tags:["chaosforge"],Item:{id:"minecraft:glow_item_frame",Count:1b,tag:{CustomModelData:7777}},Invulnerable:1b,Invisible:1b,Fixed:1b}}}}

#kill items
execute as @e[tag=fresh_craft] as @s run kill @e[type=item,nbt={Item:{id:"minecraft:diamond",Count:1b}},limit=1,sort=nearest]
execute as @e[tag=fresh_craft] as @s run kill @e[type=item,nbt={Item:{id:"minecraft:ender_pearl",Count:1b}},limit=1,sort=nearest]
execute as @e[tag=fresh_craft] as @s run kill @e[type=item,nbt={Item:{id:"minecraft:obsidian",Count:1b}},limit=1,sort=nearest]

#effects
execute at @e[tag=fresh_craft] run particle portal ~ ~ ~ 1 1 1 3 200

#sounds
execute as @e[tag=fresh_craft] as @s at @a run playsound block.end_portal.spawn master @a ~ ~ ~
execute as @e[tag=fresh_craft] as @s at @a run playsound block.anvil.use master @a ~ ~ ~

#end
execute as @e[tag=fresh_craft] run tag @s remove fresh_craft