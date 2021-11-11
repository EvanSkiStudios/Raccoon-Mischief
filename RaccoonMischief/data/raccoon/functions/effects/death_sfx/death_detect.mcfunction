tag @a[scores={deathDetect=1..}] add died
execute as @a[tag=died] at @a[tag=died] run playsound minecraft:custom.player.no master @a[tag=died] ~ ~ ~

#resetmagic mirror damage
scoreboard players set @a[tag=died] MagicMirrorDam 0

function raccoon:effects/death_sfx/death_detect_reset