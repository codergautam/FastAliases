package com.codergautamyt.fastaliases.alias;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

public class AliasList {
    static Alias[] list;
    static Alias[] total;
    static CommandMap commandMap;
    public void save(Alias alias) {
        list = (Alias[]) ArrayUtils.add(list, alias);
        total = (Alias[]) ArrayUtils.add(total, alias);
        Bukkit.getServer().getLogger().info(alias.alias + " added to list");
    }
    public static void clear() {
        list = new Alias[0];
        Bukkit.getServer().getLogger().info( "cleared");
    }
    public void setCommandMap(CommandMap commandMap1) {
        commandMap = commandMap1;
        Bukkit.getServer().getLogger().info( "commnad map set");
    }
    public static boolean contains(final Alias[] array, final String v) {

        boolean result = false;

        for(Alias i : array){
            Bukkit.getServer().getLogger().info("ALias check: /"+i.alias);
            if(("/"+i.alias).equals(v)){
                result = true;
                break;
            }
        }

        return result;
    }

}
