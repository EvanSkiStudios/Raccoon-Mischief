#### Scoreboards

# Detect eating the base item
scoreboard objectives add rm_ndirt_eat minecraft.used:minecraft.baked_potato
scoreboard objectives add rm_netherwarp_eat minecraft.used:minecraft.baked_potato
scoreboard objectives add rm_lava_cup_eat minecraft.used:minecraft.honey_bottle

scoreboard objectives add rm_me_creeper_power_eat minecraft.used:minecraft.sweet_berries

# Delay for detecting if player has recently held custom item
scoreboard objectives add rm_ndirt_delay dummy
scoreboard objectives add rm_netherwarp_delay dummy
scoreboard objectives add rm_lava_cup_delay dummy

scoreboard objectives add rm_me_creeper_power_delay dummy

scoreboard players add @a rm_ndirt_eat 0
scoreboard players add @a rm_netherwarp_eat 0

scoreboard players add @a rm_me_creeper_power_eat 0