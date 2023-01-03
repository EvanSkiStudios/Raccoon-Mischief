execute store result score @s rm_RANDOM run loot spawn ~ ~-5 ~ loot raccoon:random_gen

execute as @s[scores={rm_RANDOM=0}] run execute as @a run playsound minecraft:custom.crafting.tacticaldirt_merc player @a ~ ~ ~ 
execute as @s[scores={rm_RANDOM=1}] run execute as @a run playsound minecraft:custom.crafting.tacticaldirt_evan player @a ~ ~ ~