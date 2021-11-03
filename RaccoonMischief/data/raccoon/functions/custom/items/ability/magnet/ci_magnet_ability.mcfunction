#execute as @e[type=minecraft:item] if entity @a[scores={holding_magnet=2},distance=0..5,sort=nearest,limit=1] as @s facing entity @a[scores={holding_magnet=2},distance=0..5,sort=nearest,limit=1] eyes run tp @s ^ ^ ^0.1

#execute as @s run execute at @e[type=minecraft:item,distance=0..5,sort=nearest,limit=1] run summon minecraft:arrow

execute as @e[type=minecraft:item,distance=0..5,sort=nearest] at @s run tp @s @a[scores={holding_magnet=2..},distance=0..5,sort=nearest,limit=1]