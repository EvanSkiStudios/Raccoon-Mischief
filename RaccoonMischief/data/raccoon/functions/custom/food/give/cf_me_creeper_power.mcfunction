#takes the recipe so you can craft item again
recipe take @s raccoon:crafting/custom/food/rcip_me_creeper_power

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/food/me_creeper_power

#actually gives the item from crafting
give @p sweet_berries{display:{Name:'{"text":"Creeper Powder"}',Lore:['{"text":"Gives you the power of a Creeper","italic":true}']},CustomModelData:1,creeper_power_eat:1b}

#accidently made it so if someone crafts this, everyone gets it, seemed fun so keeping it for this

#gets rid of the useless book
clear @s minecraft:knowledge_book

#advancment
