#make player invisable
effect give @s invisibility 1 1 true

#make player unable to move
effect give @s slowness 1 255 true

#set a barrel block below them
execute unless block ~ ~-1 ~ minecraft:barrel run function raccoon:effects/barrel_hat/barrel_hat_hide_setblock