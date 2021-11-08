#takes the recipe so you can craft item again
recipe take @s raccoon:crafting/custom/food/rcip_cf_nutrientdirt

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/food/nutrient_dirt

#actually gives the item from crafting
give @a baked_potato{ndirt_eat:1b,CustomModelData:1,display:{Name:'{"text":"Nutrient Block","italic":false}'}}

#accidently made it so if someone crafts this, everyone gets it, seemed fun so keeping it for this

#gets rid of the useless book
clear @s minecraft:knowledge_book