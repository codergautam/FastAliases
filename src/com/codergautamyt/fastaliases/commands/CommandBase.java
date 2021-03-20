package com.codergautamyt.fastaliases.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandBase implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args[0].equalsIgnoreCase("reload")) {
            new ReloadCommand().run(commandSender);
        } else {
            commandSender.sendMessage(ChatColor.RED+"Subcommand not found!");
        }
        return true;
    }
}
