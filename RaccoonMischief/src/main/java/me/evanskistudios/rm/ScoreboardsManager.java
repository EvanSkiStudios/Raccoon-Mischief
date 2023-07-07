package me.evanskistudios.rm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardsManager implements Listener {

    public static Scoreboard ScoreBoardManager;
    public static Objective TestObjective;
    static final RaccoonMischief plugin = RaccoonMischief.getPlugin();
    public static void Scoreboards() {
        ScoreBoardManager = Bukkit.getScoreboardManager().getMainScoreboard();

        try{
            TestObjective = ScoreBoardManager.registerNewObjective("Evanski_Test_Scoreboard", "dummy", "Scoreboard Title");
        }catch(Throwable IllegalArgumentException){
            TestObjective = ScoreBoardManager.getObjective("Evanski_Test_Scoreboard");
        }
        TestObjective.isModifiable();
    }

    public static void Events() {
        //gets called from main, and enables the listener below
        ScoreboardsManager ScoreboardPlayerJoinEvent = new ScoreboardsManager();
        plugin.getServer().getPluginManager().registerEvents(ScoreboardPlayerJoinEvent, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        int scoreValue;

        try{
            scoreValue = TestObjective.getScore(player.getDisplayName()).getScore();
        }catch(Throwable IllegalStateException){
            Score score = TestObjective.getScore(player.getDisplayName());
            score.setScore(1);
        }
    }
}
