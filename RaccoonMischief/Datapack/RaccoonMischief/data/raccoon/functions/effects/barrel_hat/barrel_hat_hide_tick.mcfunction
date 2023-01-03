#if wearing barrel hat
execute as @a[nbt={Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat"}'}}}]}] run scoreboard players set @s rm_barrel_hat 1

execute as @a[nbt={Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat invis"}'}},}]}] run scoreboard players set @s rm_barrel_hat 1

#if not wearing barrel_hat
execute as @a[scores={rm_barrel_hat=1..},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat"}'}},}]},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat invis"}'}},}]}] run scoreboard players set @s rm_barrel_hat 0

execute as @a[scores={rm_barrel_hat_sneak=1..},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat"}'}},}]},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat invis"}'}},}]}] run scoreboard players set @s rm_barrel_hat_sneak 0

execute as @a[scores={rm_barrel_hat_sneak=..0}] run scoreboard players set @s rm_barrel_hat_jump 0 

execute as @a[scores={rm_barrel_hat_jump=1..},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat"}'}},}]},nbt=!{Inventory:[{Slot:103b,id:"minecraft:carved_pumpkin",tag:{display:{Name:'{"text":"barrel hat invis"}'}},}]}] run scoreboard players set @s rm_barrel_hat_jump 0

#hey hide the player
execute as @a[scores={rm_barrel_hat=1..,rm_barrel_hat_sneak=1..,rm_barrel_hat_jump=..0}] run execute as @s at @s run function raccoon:effects/barrel_hat/barrel_hat_hide_effects

#if player jumps
execute as @a[scores={rm_barrel_hat=1..,rm_barrel_hat_sneak=1..,rm_barrel_hat_jump=1..}] run execute as @s at @s run function raccoon:effects/barrel_hat/barrel_hat_hide_uneffect
