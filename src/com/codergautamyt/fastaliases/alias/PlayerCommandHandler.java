package com.codergautamyt.fastaliases.alias;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerCommandHandler implements Listener {
    @EventHandler
    public void onCommandProcess(PlayerCommandPreprocessEvent event) {
        ArrayList<Alias> list = AliasList.list;
        ArrayList<Alias> total = AliasList.total;
        String message = event.getMessage(); // Getting the message
        Bukkit.getServer().getLogger().info("Message "+message);
            if(AliasList.isBlocked(message)) {
                Bukkit.getServer().getLogger().info("canceled ");
                event.setCancelled(true);
            }


    }
}
