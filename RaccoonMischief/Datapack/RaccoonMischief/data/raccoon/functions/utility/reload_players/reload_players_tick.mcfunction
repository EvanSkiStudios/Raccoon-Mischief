#added to the minecraft tick tag so this should auto tick itself
scoreboard players add @a rm_setup_players 0

execute as @a[scores={rm_setup_players=..0}] run execute as @s at @s run function raccoon:utility/reload_players/reload_players_reset