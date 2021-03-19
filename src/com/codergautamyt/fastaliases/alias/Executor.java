package com.codergautamyt.fastaliases.alias;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Executor implements CommandExecutor {
    String[] execute;
    Executor(String[] execute) {
        this.execute = execute;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for (String run : execute) {
            Bukkit.dispatchCommand(commandSender, run);
        }
        return true;
    }
}
