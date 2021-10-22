#Place
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=!placed] at @s run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_place

#Remove
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=placed] at @s unless block ~ ~ ~ minecraft:dropper run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_remove


#execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=placed] at @s if entity @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=placed,distance=1..2] run say Next to eachother