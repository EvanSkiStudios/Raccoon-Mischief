#takes the recipe so you can craft item again
recipe take @s raccoon:crafting/custom_food/rcip_nutriant_dirt

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom_food/nutriant_dirt

#actually gives the item from crafting
give @a baked_potato{ndirt_eat:1b,CustomModelData:1,display:{Name:'{"text":"Nutriant Block","italic":false}'}}

#gets rid of the useless book
clear @s minecraft:knowledge_book