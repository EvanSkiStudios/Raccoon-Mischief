#summon hopper minecart is none is near
execute as @s at @s unless entity @e[type=minecraft:hopper_minecart,tag=filled,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] run summon hopper_minecart ~ ~1 ~ {NoGravity:1b,Silent:1b,Invulnerable:1b,Enabled:0b,CustomDisplayTile:1b,Tags:["pocket_chest","player_chest"],CustomName:'{"text":"Pocket Dimension","italic":false}',DisplayState:{Name:"minecraft:air"}}

#fill summoned minecart
#copys items from the custom reciver block to the summoned cart
execute as @s at @s unless entity @e[type=minecraft:hopper_minecart,tag=filled,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] run data modify entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] Items set from entity @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=block_chest,limit=1] Items
tag @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] add filled

#Lock player in place
effect give @s slowness 1 255
tp @s ~ ~ ~

#teleport that minecart in front of the player
execute as @s at @s run tp @e[type=minecraft:hopper_minecart,tag=pocket_chest,tag=player_chest,distance=0..2,sort=nearest,limit=1] ~ ~1 ~


#debug summon minecart block that is the reciver
#summon hopper_minecart ~ ~1 ~ {NoGravity:1b,Silent:1b,Invulnerable:1b,Enabled:0b,CustomDisplayTile:1b,Tags:["pocket_chest","block_chest"],CustomName:'{"text":"yeet","italic":false}',DisplayState:{Name:"minecraft:air"}}

###TODO!!!!!!!!!!!!!!!!!!!!!!!

#reciver chest needs to yeet to space while someone is acessing it, more likley we need a better way to sync things in real time

#reciver chest needs marker/block to teleport to so it stays in place