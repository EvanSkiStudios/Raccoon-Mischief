#Place
#chaos forge
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=!placed] at @s run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_place

#drying rack
execute as @e[type=minecraft:glow_item_frame,tag=dryingrack,tag=!placed] at @s run function raccoon:custom/blocks/drying_rack/cb_drying_rack_place

#Remove
#chaos forge
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=placed] at @s unless block ~ ~ ~ minecraft:dropper run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_remove

#drying rack
execute as @e[type=minecraft:glow_item_frame,tag=dryingrack,tag=placed] at @s unless entity @e[type=minecraft:armor_stand,tag=dryingrack,distance=0..0.5,sort=nearest] run function raccoon:custom/blocks/drying_rack/cb_drying_rack_remove