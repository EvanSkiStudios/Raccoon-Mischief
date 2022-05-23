#if creeper is not active then keep timer at 0 when sneaking
execute as @a[scores={rm_me_creeper_enabled=0,rm_me_creeper_timer=1..}] run scoreboard players set @s rm_me_creeper_timer 0

execute as @a[scores={rm_me_creeper_enabled=1,rm_me_creeper_timer=1..}] run function raccoon:effects/mob_effects/effects/me_creeper_effects