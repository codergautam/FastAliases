package com.codergautamyt.fastaliases.alias;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;

public class UnregisterAll {
    public static void UnregisterAllCommands() {

        if(AliasList.list != null) {
            for (Alias alias : AliasList.list) {

                try {
                    final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

                    bukkitCommandMap.setAccessible(true);
                    CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
                    alias.cmd.unregister(commandMap);
                    Bukkit.getServer().getLogger().info("UNREGISTERED "+alias.alias);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        }
        AliasList.clear();
    }
}
