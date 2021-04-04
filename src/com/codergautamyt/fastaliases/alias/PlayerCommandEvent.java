package com.codergautamyt.fastaliases.alias;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerCommandEvent implements Listener {

    @EventHandler
    public List<String> onTabComplete(PlayerCommandSendEvent e) {
        Bukkit.getServer().getLogger().info("Called");
        ArrayList<Alias> blocked = AliasList.getBlocked();
        List<String> blockedCommands = new ArrayList<>();
        for (Alias alias : blocked) {
            Bukkit.getServer().getConsoleSender().sendMessage(alias.alias+ " BLOCKED");
            blockedCommands.add(alias.alias);
            blockedCommands.add(alias.alias + ":" + alias.alias);
        }
        e.getCommands().removeAll(blockedCommands);
        for(Player player : Bukkit.getOnlinePlayers()) {

            Bukkit.getServer().getLogger().info("UPDATED FOR "+player.getName());
            player.updateCommands();
        }
        return null;
    }
}
