
scoreboard objectives add rm_jetpack_trigger minecraft.used:minecraft.carrot_on_a_stick
scoreboard players add @a rm_jetpack_trigger 0

execute as @a[scores={rm_jetpack_trigger=1..}] run effect give @s levitation 1 5 true
execute as @a[scores={rm_jetpack_trigger=1..}] at @s run particle flame ~ ~ ~ 0.1 0.5 0.1 0 5 force
execute as @a[scores={rm_jetpack_trigger=1..}] at @s run playsound entity.horse.breathe player @s ~ ~ ~ 1.5 0

execute as @a[scores={rm_jetpack_trigger=0..}] as @s at @s run execute if block ~ ~-2 ~ air run effect give @s minecraft:slow_falling 1 0 true
execute as @a[scores={rm_jetpack_trigger=0..}] as @s at @s run execute if block ~ ~-2 ~ air run particle ash ~ ~-1 ~ 0.1 0.5 0.1 0 5 force 
execute as @a[scores={rm_jetpack_trigger=0..},nbt={ActiveEffects:[{Id:25b}]}] at @s run playsound entity.horse.breathe player @s ~ ~ ~ 0.2 0

execute as @a[scores={rm_jetpack_trigger=1..}] run scoreboard players set @s rm_jetpack_trigger 0