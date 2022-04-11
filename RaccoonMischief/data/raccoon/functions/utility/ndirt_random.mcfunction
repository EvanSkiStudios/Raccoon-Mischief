execute store result score @s RANDOM run loot spawn ~ 1000 ~ loot raccoon:random_gen

execute as @s[scores={RANDOM=0}] run playsound minecraft:custom.crafting.tacticaldirt_merc player @a ~ ~ ~ 100
execute as @s[scores={RANDOM=1}] run playsound minecraft:custom.crafting.tacticaldirt_evan player @a ~ ~ ~ 100