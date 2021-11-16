#execute as @e[type=minecraft:item] if entity @a[scores={holding_magnet=2},distance=0..5,sort=nearest,limit=1] as @s facing entity @a[scores={holding_magnet=2},distance=0..5,sort=nearest,limit=1] eyes run tp @s ^ ^ ^0.1

#execute as @s run execute at @e[type=minecraft:item,distance=0..5,sort=nearest,limit=1] run summon minecraft:arrow

#particle effects
execute as @e[type=minecraft:item,nbt=!{Item:{tag:{magnet:1b}}},distance=0..5,sort=nearest] at @s run particle dust_color_transition 1.000 0.000 0.000 1 0.000 0.000 1.000 ~ ~ ~ 0.2 0.3 0.2 1 5 normal
execute as @e[type=minecraft:item,nbt=!{Item:{tag:{magnet:1b}}},distance=0..5,sort=nearest] at @s run particle dust 1.000 1.000 1.000 1 ~ ~ ~ 0.2 0.3 0.2 1 5 normal

execute as @e[type=minecraft:experience_orb,distance=0..5,sort=nearest] at @s run particle dust_color_transition 1.000 0.000 0.000 1 0.000 0.000 1.000 ~ ~ ~ 0.2 0.3 0.2 1 5 normal
execute as @e[type=minecraft:experience_orb,distance=0..5,sort=nearest] at @s run particle dust 1.000 1.000 1.000 1 ~ ~ ~ 0.2 0.3 0.2 1 5 normal

#tp items
execute as @e[type=minecraft:item,nbt=!{Item:{tag:{magnet:1b}}},distance=0..5,sort=nearest] at @s run tp @s @a[scores={holding_magnet=2..},distance=0..5,sort=nearest,limit=1]

#tp xp orb
execute as @e[type=minecraft:experience_orb,distance=0..5,sort=nearest] at @s run tp @s @a[scores={holding_magnet=2..},distance=0..5,sort=nearest,limit=1]