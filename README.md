# Evanski's RaccoonMischief Minecraft Plugin

This is an Minecraft plugin, that adds new features to vanilla minecraft
This is a companion project to [Mercerenies' A-Turtles-Troll](https://github.com/Mercerenies/a-turtles-troll). 
Neither directly depends on the other, but they are designed with each other in mind.

(Probably won't understand without the resourcepack, You can get a public copy here [Textile](https://github.com/EvanSkiStudios/Textile))

## Acknowledgments
Raccoon Mischief is written and maintained by Evanski. It is
released as [All Rights Reserved](LICENSE).

# How to install
Place RaccoonMischief.jar into your plugin folder of your Paper-mc server.

# Changelog
See [Latest Features](https://github.com/EvanSkiStudios/Raccoon-Mischief/blob/master/Features/Features_Latest_.md) for full list of features

## Version 2.0
* Moved Datapack Functionality to Plugin

## Config.yml
* Info > provides a string with info about the config file, is unused by pluin so this key can be deleted/changed/ect
* Version > is used to check the plugin version for new Config keys, Do not edit otherwise will cause the pluin to behave unexpectedly 
* B_IgnorePluginGetInstalledFlag > Sets a flag for checking features of other plugins, Setting this to true will ignore checking if the referenced plugin is installed
* B_TurtlesTrollFeatures > Toggles whether if Features for [Mercerenies' A-Turtles-Troll](https://github.com/Mercerenies/a-turtles-troll) should run or not
* B_PlayersDropSkulls > Toggles if players will drop skulls on death
* B_PufferfishConversion > Toggles if Pufferfish struck by lightning convert to Guardians
* B_CustomPlayerJoinLeaveMessages > Toggles if the server should give the Custom join and leave messages
* B_ForgivingVoid > Toggles if players that fall into the void should teleport to the overworld

## Commands
* RMVer > Returns the current Version of the installed plugin
* RMTestDeath > (OP only) A testing command that sets the players health to 1 to test Death effects
* RMGetCFG > Gets the value of a specified key in the config.yml
* RMReloadCFG > (OP only) Reloads the config.yml file
* RMGive > (OP only) Gives an selected RM item, much like the vanilla give command but for RM items only
* RMShowCraft > Shows the crafting recipe of an RM recipe

## Vanilla Changes
Things That change vanilla features
* The Server Welcome message has been changed to "Welcome to HELL, {Player Name}"
* The Server Leave message has been changed to "{Player Name} Escaped!"
* Harder Armor crafting > Armor now requires the previous tier of armor to craft
* Iron armor can be upgraded into Golden at smithing table

## Recipes
* XP Orb > Makes an xp orb that is worth 1 level  
* [JTE Apple](https://www.minecraftforum.net/forums/minecraft-java-edition/discussion/2109197-the-secret-history-of-minecraft-with-proof#c1) > Enchanted Golden Apple
* Tactical Dirt > New food item with the same stats as a baked potato 
* Dirt to Seeds > 4 Dirt makes Seeds
* Rotten Flesh to Leather > can be cooked on furnace, smoker or campfire
* Milk Potion > A potion that removes potion effects
* UnMetaDataCookies > Removes Meta Data from cookies (A-Turtles-Troll adds meta to the cookies to prevent stacking)

## Effects
* If a player falls into the void they will be teleported to the same coords at the top of the overworld
* If a Pufferfish is struck by lightning it converts to a Guardian
* Players will now drop skulls on death if config is true
* You can now milk player entities 
* Players now drop Beef that is named "Strange Meat" on death
* The sound effect of [Jeb screaming](https://youtu.be/2BCFGjsrwyY?t=26) will play when a player dies
* The sound effect of [DinnerBone yelling](https://youtu.be/PpF8AaPyqhQ?t=120) will play when a player is killed by a llama
* The line ["Im Levitating"](https://youtu.be/GOhLQ4fchSc?t=27) will play when a player is under the effect of Levitation
