package com.codergautamyt.fastaliases;

import com.codergautamyt.fastaliases.alias.ConfigException;
import com.codergautamyt.fastaliases.alias.ConfigLoader;
import com.codergautamyt.fastaliases.commands.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FastAliases extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        //for reloads
        reloadConfig();
        config = getConfig();

        ConfigLoader configLoader = new ConfigLoader(this, config);
        try {
            configLoader.loadConfig();
        } catch (ConfigException e) {
            e.printStackTrace();
            getServer().getConsoleSender().sendMessage(ChatColor.RED+" [FastAliases] Your config couldn't be parsed. For more information, see the error above");
            getServer().getConsoleSender().sendMessage(ChatColor.BLUE+" [FastAliases] Still need help? Email me with error message at gautamgxtv@gmail.com or join the discord");
            getServer().getConsoleSender().sendMessage(ChatColor.RED+" [FastAliases] Disabling the plugin, please correct the above error and restart server");
            getServer().getPluginManager().disablePlugin(this);
        }
        getCommand("fastaliases").setExecutor(new CommandBase());
        getLogger().info("Enabled FastAliases v1.0 - By CoderGautamYT");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled FastAliases v1.0 - By CoderGautamYT");
    }
}