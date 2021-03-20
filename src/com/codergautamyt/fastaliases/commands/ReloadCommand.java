package com.codergautamyt.fastaliases.commands;

import com.codergautamyt.fastaliases.alias.UnregisterAll;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ReloadCommand {
    public void run(CommandSender sender) {
        if(sender.isOp() || sender.hasPermission("fastaliases.reload")) {
            sender.sendMessage(ChatColor.YELLOW+"[FastAliases] WARNING! Reloading the plugin is Experimental and might cause problems. If you get any problems after reloading, please open a new Github issue.");
            sender.sendMessage(ChatColor.GREEN+"[FastAliases] Reloading the plugin...");
            try {
                UnregisterAll.UnregisterAllCommands();
            } catch(Exception e) {
                sender.sendMessage(ChatColor.RED+"AN ERROR OCCURRED WHILE UNREGISTERING ALIASES");
                sender.sendMessage(ChatColor.RED+"PLEASE SEND TRACK TRACE(in logs) ON A GITHUB ISSUE");
                sender.sendMessage(e.getMessage());
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Stack trace below(copy and send in github):");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "An error occurred when unregistering commands during plugin reload");
                e.printStackTrace();
                return;
            }
            sender.sendMessage(ChatColor.GREEN+"[FastAliases] Cleared Aliases!");
            Plugin plugin = Bukkit.getPluginManager().getPlugin("FastAliases");
            try {
                Bukkit.getPluginManager().disablePlugin(plugin);
                Bukkit.getPluginManager().enablePlugin(plugin);
            } catch(Exception e) {
                sender.sendMessage(ChatColor.RED+"AN ERROR OCCURRED WHILE RESTARTING PLUGIN");
                sender.sendMessage(ChatColor.RED+"PLEASE SEND TRACK TRACE(in logs) ON A GITHUB ISSUE");
                sender.sendMessage(e.getMessage());
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Stack trace below(copy and send in github):");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "An error occurred when restarting plugin during plugin reload");
                e.printStackTrace();
                return;
            }
            sender.sendMessage(ChatColor.GREEN+"[FastAliases] Aliases were added successfully!");
            sender.sendMessage(ChatColor.GREEN+"[FastAliases] Plugin reloaded successfully!");
        } else {
            sender.sendMessage(ChatColor.RED+ "You don't have permission to run this command");
        }
    }
}
