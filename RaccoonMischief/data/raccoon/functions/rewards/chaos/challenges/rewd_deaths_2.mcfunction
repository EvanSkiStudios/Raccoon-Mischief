tag @s remove tobekilled
kill @a[tag=tobekilled]

tellraw @a {"text":"","extra":[{"selector":"@a[tag=tobekilled]"},{"text":" Died from being killed"}]}
tag @a[tag=tobekilled] remove tobekilled