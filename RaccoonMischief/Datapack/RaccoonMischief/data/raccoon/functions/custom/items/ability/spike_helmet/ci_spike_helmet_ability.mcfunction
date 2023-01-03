#deflect anvil
execute as @s at @s run execute at @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:anvil"}},tag=!deflected] as @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:anvil"}},tag=!deflected] run function raccoon:custom/items/ability/spike_helmet/deflect/ci_sh_a_anvil


#deflect dripstone
execute as @s at @s run execute at @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:pointed_dripstone"}},tag=!deflected] as @e[type=minecraft:falling_block,distance=0..3,sort=nearest,nbt={BlockState:{Name:"minecraft:pointed_dripstone"}},tag=!deflected] run function raccoon:custom/items/ability/spike_helmet/deflect/ci_sh_a_stone