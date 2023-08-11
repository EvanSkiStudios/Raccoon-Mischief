package me.evanskistudios.rm.Utilis;

import me.evanskistudios.rm.RaccoonMischief;

import java.util.Random;

import static java.lang.Math.floor;

public class UtilityMethods {
    private static final Random random = new Random();
    public static Object Choose(Object[] args){
        return args[random.nextInt(args.length)];
        /*Returns an item in the object array randomly
        Call like so>
        Type[] Var = {Fish, Chicken, Cow}
        Object test_return = UtilChoose.Choose(Var);*/
    }

    public static Object RandomPlayer(){
        Object[] PlayersOnline = RaccoonMischief.getPlugin().getServer().getOnlinePlayers().toArray();

        return ( Choose(PlayersOnline) ) ;
    }

    public static double MCHearts(double Hearts){
        return (Hearts / 0.5);
        //Returns the amount of hearts (20.0 is 10 hearts)
    }

    public static int SecondsToTicks(double Seconds){
        return (int) floor(Seconds * 20);
        //Returns the amount of ticks 20 Ticks = 1 Second
    }

}
