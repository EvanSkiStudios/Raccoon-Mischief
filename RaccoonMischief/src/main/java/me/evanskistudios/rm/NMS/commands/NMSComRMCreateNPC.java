package me.evanskistudios.rm.NMS.commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NMSComRMCreateNPC implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if (sender instanceof Player player){
            CraftPlayer craftPlayer = (CraftPlayer) player;
            ServerPlayer sp = craftPlayer.getHandle();

            MinecraftServer server = sp.getServer();
            ServerLevel level = sp.getLevel();

            String npc_name = "Not_Mercerenies";

            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npc_name);

            String signature = "aSNRyG4TQPOHxEic1aZYI6SK3agOL37DJ2DmNGaXAthS96QdRhDYXmWl2Xqo19IlLZJMzSOzkBIUKt98mU4cEHEgr0L7KXrIf0OXcL0q8vV4EL8KqqWg7hl6EtOQI0vq8e0JoL/7akPlla+nkQcFQ/+ZmrWIr4BO4z6oimYHtPSXgINihHMZpN7mnO0Oma7h5VoXcRN3Vrd2U+abVIc8MqEtWUwCcAhqVj1/j+kTkI6Nh5ByJqUC/nOHdrNLp4VEfBr1D4R2xeg/xIfMHuep+UC8Ac10qoEl9fPXRkSoCkMshcX8U0DMKykYrLYHP0E3SL75lQBNarEDdUGmoHO/Gs2OVlrwhQhhoiIrl/B0HZLMic/ndCyGZz3bph2jgJGR/dzuPZNHFlVcuGdyCI1spe0lh+fsTDe51zH+KYxkOi2kDMdNo9oX6zoV2dQIfsx1/0XnaSdr01XaB6s2xuS2I1p1taH7EUwp/XuLXW33Um7dnOHBRDD0RR+knYnKXD/oqHrzaB1LfzGbZofdvLzOxzEOgh+zJhJdm0uBO3tPOKQf1/iRxxOOOlECRgEvUIUaJmIOBJ9/nfZd4/O3iPJcJO0jHoWa3UHP4hVMX/KJXUFg2KEYoXw/ATXQcRlinAZecTY5cGnyi1b7+HcCEHPqD+RNkVNyNkQaDswnAxxMkew=";
            String texture = "ewogICJ0aW1lc3RhbXAiIDogMTY3NDUyMjYxNDg5NSwKICAicHJvZmlsZUlkIiA6ICI5Y2VhNWNkMzgzMzI0Nzc2YWIxOWVlZDZkMWIzODIzZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNZXJjZXJlbmllcyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YjI4ZTRiODJiMWIzMDBkZjgyOTViMmM3ZjRiMjlmOWQzMWZiMTczMDc3ZWE3Nzg4NmM3YmM5ODQxNTYyYWNjIgogICAgfSwKICAgICJDQVBFIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yMzQwYzBlMDNkZDI0YTExYjE1YThiMzNjMmE3ZTllMzJhYmIyMDUxYjI0ODFkMGJhN2RlZmQ2MzVjYTdhOTMzIgogICAgfQogIH0KfQ==";

            gameProfile.getProperties().put("textures", new Property("textures", texture, signature));

            ServerPlayer npc = new ServerPlayer(server, level, gameProfile);
            npc.setPos(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            ServerGamePacketListenerImpl ps = sp.connection;

            //PLayerInfoPacket
            ps.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));


            //Spawn Packet
            ps.send(new ClientboundAddPlayerPacket(npc));

            sender.sendMessage(ChatColor.YELLOW+"Welcome to HELL, "+npc_name+"!");
        }


        return true;
    }
}
