#get rid of drowned they spawn uncontrollably and cause massive lag
execute as @e[type=minecraft:drowned] run tp @s ~ -300 ~

#Get rid of lava underplayers this is just annoying and destructive
execute at @a run fill ~ ~-2 ~ ~ ~-2 ~ minecraft:air replace minecraft:lava

#No
execute as @e[type=minecraft:warden] run tp @s ~ -300 ~

#deflect dripstone, I hate this
execute as @a at @a run execute at @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:pointed_dripstone"}},tag=!deflected] as @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:pointed_dripstone"}},tag=!deflected] run kill @s