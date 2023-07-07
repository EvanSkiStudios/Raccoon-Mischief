package me.evanskistudios.rm.utilis;

import java.util.Random;

public class UtilityMethods {
    private static final Random random = new Random();
    public static Object Choose(Object[] args){
        return args[random.nextInt(args.length)];
        /*Returns an item in the object array randomly
        Call like so>
        Type[] Var = {Fish, Chicken, Cow}
        Object test_return = UtilChoose.Choose(Var);*/
    }

    public static double MCHearts(double Hearts){
        return (Hearts / 0.5);
        //Returns the amount of hearts (20.0 is 10 hearts)
    }

}
