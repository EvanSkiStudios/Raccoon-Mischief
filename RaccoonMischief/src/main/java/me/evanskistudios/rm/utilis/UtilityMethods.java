package me.evanskistudios.rm.utilis;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

public class UtilityMethods {
    private static final Random random = new Random();
    public static Object Choose(Object[] args){

        return args[random.nextInt(args.length)];
        /*Returns an item in the object array randomly
        Call like so>
        Type[] Var = {Fish, Chicken, Cow}
        Object test_return = UtilChoose.Choose(Var);*/

        //        List<Object> test = new ArrayList<Object>();
        //        test.add("Fish");
    }

    public static double MCHearts(double Hearts){
        return (Hearts / 0.5);
    }
}
