#deflect arrows
execute as @s at @s run execute at @e[type=minecraft:arrow,distance=0..3,sort=nearest,tag=!deflected] as @e[type=minecraft:arrow,distance=0..3,sort=nearest,tag=!deflected] run function raccoon:custom/items/ability/magic_mirror/deflect/ci_mm_a_arrow

#deflect eggs
execute as @s at @s run execute at @e[type=minecraft:egg,distance=0..3,sort=nearest,tag=!deflected] as @e[type=minecraft:egg,distance=0..3,sort=nearest,tag=!deflected] run function raccoon:custom/items/ability/magic_mirror/deflect/ci_mm_a_egg