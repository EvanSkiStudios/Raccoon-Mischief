#armor stand marker
execute align xz positioned ~0.5 ~ ~0.5 run summon armor_stand ~ ~ ~ {CustomName:'{"text":"raccoon"}',Small:1b,NoGravity:1b,Silent:1b,Invulnerable:1b,Marker:1b,Invisible:1b,NoBasePlate:1b,Tags:["dryingrack_marker"],ArmorItems:[{},{},{},{}]}

#interacting armorstand
execute align xz positioned ~0.5 ~ ~0.5 run summon armor_stand ~ ~ ~ {Pose:{RightArm:[0.0f,-90.0f,-0.0f]},CustomName:'{"text":"raccoon"}',NoGravity:1b,Silent:1b,Invisible:0b,NoBasePlate:1b,ShowArms:1b,DisabledSlots:62,Tags:["dryingrack"],ArmorItems:[{},{},{},{}]}

#finish
tag @s add placed