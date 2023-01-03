give @p splash_potion{milk_potion:1b,display:{Name:'{"text":"Splash Potion of Milk","italic":false,"color":"white"}',"Lore":['{"text":"Removes all potion effects","color":"blue","italic":false}']},CustomModelData:1,Enchantments:[{}],CustomPotionColor:16777215} 

recipe take @s raccoon:crafting/custom/item/rcip_milk_potion

#gets rid of the useless book
clear @s minecraft:knowledge_book

#reset advancment
advancement revoke @s only raccoon:utilities/custom/item/milk_potion