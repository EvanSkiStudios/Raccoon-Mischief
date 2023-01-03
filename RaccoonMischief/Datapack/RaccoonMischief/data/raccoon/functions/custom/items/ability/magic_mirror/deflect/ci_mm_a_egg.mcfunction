scoreboard players add @p rm_MagicMirrorDam 2
#tells player the duribility
execute as @p at @p run tellraw @p ["",{"text":"Your Mirror's Damage: "},{"score":{"name":"@p","objective":"rm_MagicMirrorDam"},"color":"blue"}]

kill @s