#takes the recipe so you can craft item again
recipe take @s minecraft:leather

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/item/rabbit_leather

#give item
give @a beetroot_seeds{CustomModelData:827200,display:{Name:'{"text":"Raw Hide","italic":false}'}}

#gets rid of the useless book
clear @s minecraft:knowledge_book