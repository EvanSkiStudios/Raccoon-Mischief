#takes the recipe so you can craft item again
recipe take @s raccoon:cooking/custom/item/rcip_ci_raw_flesh

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/item/raw_flesh

#actually gives the item from crafting
give @a beetroot_seeds{CustomModelData:8270,display:{Name:'{"text":"Raw Flesh","italic":false}'}}

#gets rid of the useless book
clear @s minecraft:knowledge_book