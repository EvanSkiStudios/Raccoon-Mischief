#takes the recipe so you can craft item again
recipe take @s raccoon:crafting/custom/food/rcip_cf_netherwarp

#removes advancment so this function runs again
advancement revoke @s only raccoon:utilities/custom/food/nether_warp

#actually gives the item from crafting
give @a baked_potato{netherwarp_eat:1b,CustomModelData:2,display:{Name:'{"text":"Vortex Bloodstone","italic":false}',Lore:['{"text":"Results may vary!","italic":true}']}}

#accidently made it so if someone crafts this, everyone gets it, seemed fun so keeping it for this

#gets rid of the useless book
clear @s minecraft:knowledge_book

#advancment
advancement grant @s only raccoon:chaos/datapack/food/dp_nether_warp