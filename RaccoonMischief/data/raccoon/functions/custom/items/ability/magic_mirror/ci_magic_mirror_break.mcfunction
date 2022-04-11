playsound item.shield.break master @a[scores={rm_MagicMirrorDam=100..}] ~ ~ ~ 0.5
playsound block.glass.break master @a[scores={rm_MagicMirrorDam=100..}] ~ ~ ~ 1

clear @a[scores={rm_MagicMirrorDam=100..}] shield{CustomModelData:7777,mmirror:1b,display:{Name:'{"text":"Magic Mirror","italic":false}'}} 1

scoreboard players set @a[scores={rm_MagicMirrorDam=100..}] rm_MagicMirrorDam 0