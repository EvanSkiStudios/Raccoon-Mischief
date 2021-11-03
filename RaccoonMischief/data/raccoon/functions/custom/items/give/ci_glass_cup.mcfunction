#takes the recipe so you can craft item again
recipe take @s raccoon:crafting/custom/item/rcip_ci_glass_cup

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/item/glass_cup

give @p glass_bottle{display:{Name:'{"text":"Glass Cup","italic":false}'},CustomModelData:7167}

#gets rid of the useless book
clear @s minecraft:knowledge_book