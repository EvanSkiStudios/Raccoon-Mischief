package me.evanskistudios.rm.utilis;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.entity.Player;

import java.util.Collections;
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
    }

    public static double MCHearts(double Hearts){
        return (Hearts / 0.5);
        //Returns the amount of hearts (20.0 is 10 hearts)
    }


    public static Player getRandomPlayer() {
        RaccoonMischief plugin = RaccoonMischief.getPlugin();

        if (plugin.getServer().getOnlinePlayers().size() == 0){
            return null;
        }

        List<?> tempPlayers = (List<?>) plugin.getServer().getOnlinePlayers();
        Collections.shuffle(tempPlayers);

        Player RandomPlayer = (Player) tempPlayers.get( 0 );

        tempPlayers = null;
        return RandomPlayer;
    }

}
