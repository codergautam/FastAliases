package com.codergautamyt.fastaliases.alias;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.util.ArrayList;

public class AliasList {
    static ArrayList<Alias> list;
    static ArrayList<Alias> total;
    static CommandMap commandMap;
    public void save(Alias alias) {
        list.add(alias);
        total.add(alias);
        Bukkit.getServer().getLogger().info(alias.alias + " added to list");
    }
    public static void clear() {
        list = new ArrayList<Alias>();
       // Bukkit.getServer().getLogger().info( "cleared list");
    }
    public void setCommandMap(CommandMap commandMap1) {
        commandMap = commandMap1;
       // Bukkit.getServer().getLogger().info( "commnad map set");
    }
    public static boolean contains(final Alias[] array, final String v) {

        boolean result = false;

        for(Alias i : array){
            if(("/"+i.alias).equals(v)){
                result = true;
                break;
            }

        }

        return result;
    }
    public static boolean contains(final Alias[] array, final Alias v) {

        boolean result = false;

        for(Alias i : array){
            if(("/"+i.alias).equals(v.alias)){
                result = true;
                break;
            }

        }

        return result;
    }
    public static ArrayList<Alias> getBlocked() {
        ArrayList<Alias> blocked = new ArrayList<>();
        for(Alias alias : AliasList.total) {
            Bukkit.getServer().getLogger().info("Total: "+alias.alias);
            if(AliasList.list.contains(alias)) {

            } else {
                Bukkit.getServer().getLogger().info("Block detected: "+alias.alias);
                blocked.add(alias);
            }
        }
        return blocked;
    }
    public static boolean isBlocked(Alias alias)  {
        return getBlocked().contains(alias);
    }
    public static boolean isBlocked(String alias)  {
        ArrayList<String> blockedString = new ArrayList<>();
        ArrayList<Alias> blocked = getBlocked();
        for (Alias alias1 : blocked) {
            blockedString.add(alias1.alias);
        }
        return blockedString.contains(alias);
    }
}
