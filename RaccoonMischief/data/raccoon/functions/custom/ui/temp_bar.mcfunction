# \uE000 hot with armor
# \uE001 hot no armor
# \uE002 cold with armor
# \uE003 cold no armor
# \uF838 space size 7
# \uF829 space size 15


#in hot biome without armor
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches 10.. unless entity @s[nbt={Inventory:[{Slot:100b}]}] unless entity @s[nbt={Inventory:[{Slot:101b}]}] unless entity @s[nbt={Inventory:[{Slot:102b}]}] unless entity @s[nbt={Inventory:[{Slot:103b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE001"}]

#has armor on in hot biome
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches 10.. run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:100b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE000"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches 10.. run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:101b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE000"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches 10.. run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:102b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE000"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches 10.. run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:103b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE000"}]

#has armor on in cold biome
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches ..-10 run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:100b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE002"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches ..-10 run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:101b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE002"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches ..-10 run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:102b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE002"}]
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches ..-10 run execute as @a unless entity @s[nbt=!{Inventory:[{Slot:103b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE002"}]

#in cold biome without armor
execute if score @s com.mercerenies.turtletroll.TemperatureManager.SCOREBOARD_NAME matches ..-10 unless entity @s[nbt={Inventory:[{Slot:100b}]}] unless entity @s[nbt={Inventory:[{Slot:101b}]}] unless entity @s[nbt={Inventory:[{Slot:102b}]}] unless entity @s[nbt={Inventory:[{Slot:103b}]}] run title @s actionbar [{"text":"\uF82B\uF82A\uF825"},{"text":"\uF829\uF829\uF829\uF829\uF829\uF829\uF838\uE003"}]
