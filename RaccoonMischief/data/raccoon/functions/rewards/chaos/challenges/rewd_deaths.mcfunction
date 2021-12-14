xp add @s 200
function raccoon:custom/items/give/ci_upgrade_shard
tag @a[scores={deathcount=100..}] add tobekilled
execute as @s run schedule function raccoon:rewards/chaos/challenges/rewd_deaths_2 30s