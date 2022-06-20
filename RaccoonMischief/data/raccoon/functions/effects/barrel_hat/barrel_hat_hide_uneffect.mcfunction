#remove a barrel block below them
execute unless block ~ ~-1 ~ minecraft:air run setblock ~ ~-1 ~ minecraft:air
item replace entity @p armor.head with carved_pumpkin{display:{Name:'{"text":"barrel hat"}'}} 1

effect clear @s slowness
effect clear @s invisibility

scoreboard players set @s rm_barrel_hat_sneak 0
scoreboard players set @s rm_barrel_hat_jump 0