#tp item
execute as @e[type=minecraft:item,nbt=!{Item:{tag:{super_magnet:1b}}},distance=0..15,sort=nearest] at @s run tp @s @a[scores={rm_holding_s_magnet=2..},distance=0..15,sort=nearest,limit=1]

#tp xp orb
execute as @e[type=minecraft:experience_orb,distance=0..15,sort=nearest] at @s run tp @s @a[scores={rm_holding_s_magnet=2..},distance=0..15,sort=nearest,limit=1]