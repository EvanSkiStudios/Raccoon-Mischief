package me.evanskistudios.rm;

import me.evanskistudios.rm.Commands.*;

import java.util.Objects;

public class ComManager {

    public static void commands(){
       RaccoonMischief RM = RaccoonMischief.getPlugin();

        Objects.requireNonNull(RM.getCommand("RMVER")).setExecutor(new ComGetRMVer());
        Objects.requireNonNull(RM.getCommand("RMtestDeath")).setExecutor(new ComRMTestDeath());
        Objects.requireNonNull(RM.getCommand("RMGetCfg")).setExecutor(new ComRMGetConfig());
        Objects.requireNonNull(RM.getCommand("RMReloadCfg")).setExecutor(new ComRMReloadConfig());
        Objects.requireNonNull(RM.getCommand("RMGive")).setExecutor(new ComRMGive());
        Objects.requireNonNull(RM.getCommand("RMShowCraft")).setExecutor(new ComRMShowCraft());
        Objects.requireNonNull(RM.getCommand("RMEnchant")).setExecutor(new ComRMEnchant());
        Objects.requireNonNull(RM.getCommand("RMQuickTest")).setExecutor(new ComRMQuickTest());
    }
}
