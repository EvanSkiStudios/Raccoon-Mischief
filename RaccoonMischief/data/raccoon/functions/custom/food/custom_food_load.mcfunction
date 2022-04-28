#### Scoreboards

# Detect eating the base item
scoreboard objectives add rm_ndirt_eat minecraft.used:minecraft.baked_potato
scoreboard objectives add rm_netherwarp_eat minecraft.used:minecraft.baked_potato
scoreboard objectives add rm_lava_cup_eat minecraft.used:minecraft.honey_bottle

# Delay for detecting if player has recently held custom item
scoreboard objectives add rm_ndirt_delay dummy
scoreboard objectives add rm_netherwarp_delay dummy
scoreboard objectives add rm_lava_cup_delay dummy