package com.codergautamyt.fastaliases.commands;

import com.codergautamyt.fastaliases.alias.UnregisterAll;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class UnregisterCommand {
    public void run(CommandSender sender) {
        if(sender.isOp() || sender.hasPermission("fastaliases.reload")) {
            sender.sendMessage(ChatColor.GREEN+"[FastAliases] Unregistering all aliases...");
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
        } else {
            sender.sendMessage(ChatColor.RED+ "You don't have permission to run this command");
        }
    }
}
