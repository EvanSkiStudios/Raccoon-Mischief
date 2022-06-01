execute as @a[scores={rm_player_is_sneaking=..0,rm_player_is_jumping=1..,rm_me_creeper_enabled=1,rm_me_creeper_timer=2..}] run scoreboard players set @s rm_me_creeper_timer 0

execute as @a[scores={rm_me_creeper_enabled=1,rm_me_creeper_timer=2}] at @s run playsound entity.tnt.primed master @s ~ ~ ~

execute as @a[scores={rm_me_creeper_enabled=1,rm_player_is_sneaking=1..,rm_me_creeper_timer=1..}] at @s run particle minecraft:cloud ~ ~1 ~ 0 0 0 0.1 3

execute as @a[scores={rm_me_creeper_enabled=1,rm_me_creeper_timer=60..}] at @s run summon minecraft:tnt ~ ~ ~

execute as @a[scores={rm_me_creeper_enabled=1,rm_me_creeper_timer=60..}] run scoreboard players set @s rm_me_creeper_enabled 0