package com.codergautamyt.fastaliases.alias;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class ConfigLoader {
    JavaPlugin plugin;
    FileConfiguration config;
    AliasList aliasList = new AliasList();
    public ConfigLoader(JavaPlugin plugin, FileConfiguration config) {
        this.plugin = plugin;
        this.config = config;
    }
    public void loadConfig() throws ConfigException {
try {
            for (String id : config.getConfigurationSection("commands").getKeys(false)) {
                //for each command
                String[] execute = new String[0];
                String[] aliases = new String[0];
                try {
                    for (String subkey : config.getConfigurationSection("commands." + id).getKeys(false)) {
                        if (subkey.equalsIgnoreCase("execute")) {
                            try {
                                for (String execute1 : config.getConfigurationSection("commands." + id + ".execute").getKeys(false)) {
                                    execute = (String[]) ArrayUtils.add(execute, config.getString("commands." + id + ".execute." + execute1 + ".name"));
                                }
                            } catch(NullPointerException e) {
                                throw new ConfigException("Error at Alias #" + id + System.lineSeparator() + "You didn't specify the executor command!");
                            }
                        } else if (subkey.equalsIgnoreCase("aliases")) {
                            try {
                                for (String aliases1 : config.getConfigurationSection("commands." + id + ".aliases").getKeys(false)) {
                                    aliases = (String[]) ArrayUtils.add(aliases, config.getString("commands." + id + ".aliases." + aliases1 + ".name"));
                                }
                            } catch(NullPointerException e) {
                                throw new ConfigException("Error at Alias #" + id + System.lineSeparator() + "You didn't specify an alias!");
                            }
                        } else {
                            throw new ConfigException("Error at Alias #" + id + System.lineSeparator() + "Expected execute or aliases, got " + subkey);
                        }
                    }
                    try {



                    for (String alias : aliases) {

                        try {
                                Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                                commandMapField.setAccessible(true);
                                CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
                                aliasList.setCommandMap(commandMap);

                                Alias aliasObj = new Alias(alias, new Executor(alias, execute));

                                commandMap.register(alias, aliasObj.cmd);
                                aliasList.save(aliasObj);
                                plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FastAliases] Successfully loaded alias " + alias);


                        } catch(NullPointerException e) {
                            e.printStackTrace();
                            throw new ConfigException("UNEXPECTED ERROR CONTACT DEV");
                        }
                    }
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new ConfigException("UNEXPECTED ERROR CONTACT DEV");
                    }
                }catch (NullPointerException e) {
                    plugin.getServer().getConsoleSender().sendMessage("--------TECHNICAL INFO--------");
                    e.printStackTrace();
                    throw new ConfigException("Error at Alias #" + id + System.lineSeparator() + "You didn't add 'execute' or 'aliases' after Alias id");

                }
                }

        } catch(NullPointerException e) {
    plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "[FastAliases] You haven't added any aliases! To add one, go to config.yml in the FastAliases folder");
        }
    }
}
