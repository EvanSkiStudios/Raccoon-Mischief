package me.evanskistudios.rm.utilis;

import java.util.List;
import java.util.Random;

public class UtilityMethods {
    private static final Random random = new Random();
    public static Object Choose(List<Object> args){
        return args.get(random.nextInt(args.size()));
        /*Returns an item in the object list randomly
        Call like so>
        List<Object> test = new ArrayList<Object>();
        test.add("Fish");

        Object test_return = UtilChoose.Choose(test);*/
    }
}
