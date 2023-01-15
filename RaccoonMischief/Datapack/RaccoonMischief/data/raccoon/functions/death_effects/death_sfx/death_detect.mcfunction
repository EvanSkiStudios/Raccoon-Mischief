tag @a[scores={rm_deathDetect=1..,rm_llamaDetect=..0}] add died
execute as @a[tag=died] at @a[tag=died] run playsound minecraft:custom.player.no player @a[tag=died] ~ ~ ~

#resetmagic mirror damage
scoreboard players set @a[tag=died] rm_MagicMirrorDam 0

function raccoon:death_effects/death_sfx/death_detect_reset