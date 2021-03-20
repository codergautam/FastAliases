package com.codergautamyt.fastaliases.alias;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

public class AliasList {
    static Alias[] list;
    static CommandMap commandMap;
    public void save(Alias alias) {
        list = (Alias[]) ArrayUtils.add(list, alias);
        Bukkit.getServer().getLogger().info(alias.alias + " added to list");
    }
    public static void clear() {
        list = new Alias[0];
        commandMap = null;
        Bukkit.getServer().getLogger().info( "cleared");
    }
    public void setCommandMap(CommandMap commandMap1) {
        commandMap = commandMap1;
        Bukkit.getServer().getLogger().info( "commnad map set");
    }

}
