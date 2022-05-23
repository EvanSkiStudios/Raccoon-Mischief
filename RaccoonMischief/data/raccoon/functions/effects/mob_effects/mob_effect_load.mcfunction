#remove flags
scoreboard objectives remove rm_me_creeper_enabled

#remove effect timer 
scoreboard objectives remove rm_me_creeper_timer


#add flags
scoreboard objectives add rm_me_creeper_enabled dummy
scoreboard players add @a rm_me_creeper_enabled 0

#add effect timer 
scoreboard objectives add rm_me_creeper_timer minecraft.custom:minecraft.sneak_time
scoreboard players add @a rm_me_creeper_timer 0