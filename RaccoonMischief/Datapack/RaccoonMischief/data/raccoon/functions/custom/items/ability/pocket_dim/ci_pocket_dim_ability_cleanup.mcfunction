#copys items from the summoned cart to the reciver
data modify entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=block_chest,limit=1] Items set from entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] Items

#clear players slowness letting them move again
effect clear @s

#turn gravity on
execute as @s at @s run data modify entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..3,sort=nearest,limit=1] NoGravity set value 0
execute as @s at @s run data modify entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..3,sort=nearest,limit=1] OnGround set value 1

#throw chest in the void
execute as @s at @s run tp @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..3,sort=nearest,limit=1] ~ ~-21000 ~