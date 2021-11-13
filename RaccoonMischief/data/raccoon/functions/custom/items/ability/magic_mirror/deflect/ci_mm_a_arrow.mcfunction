#tells player the duribility
execute as @p at @p run tellraw @p ["",{"text":"Your Mirror's Damage: "},{"score":{"name":"@p","objective":"MagicMirrorDam"},"color":"blue"}]

data modify entity @s Motion set value 0.0
tag @s add deflected