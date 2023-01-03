schedule function raccoon:custom/items/ability/miners_helmet/ci_miners_helmet_tick 10t

execute as @e[type=minecraft:marker,tag=light_bulb] at @s run function raccoon:custom/items/ability/miners_helmet/ci_miners_helmet_kill_light

execute as @a[nbt={Inventory:[{Slot: 103b, id:"minecraft:carved_pumpkin", tag:{ug_minehelm:1b}}]}] at @s run function raccoon:custom/items/ability/miners_helmet/ci_miners_helmet_set_light