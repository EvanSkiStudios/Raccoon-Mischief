#=====Place======
#chaos forge
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=!placed] at @s run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_place

#=====Remove======
#chaos forge
execute as @e[type=minecraft:glow_item_frame,tag=chaosforge,tag=placed] at @s unless block ~ ~ ~ minecraft:dropper run function raccoon:custom/blocks/chaos_forge/cb_chaos_forge_remove


#====useability=====