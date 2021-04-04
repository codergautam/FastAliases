package com.codergautamyt.fastaliases.alias;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Executor extends Command {
    String[] execute;
    protected Executor(String name, String[] execute) {
        super(name);
        this.execute = execute;
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        for(String execute1 : execute) {
            Bukkit.getServer().dispatchCommand(sender, execute1);
        }

        return true;
    }
}
