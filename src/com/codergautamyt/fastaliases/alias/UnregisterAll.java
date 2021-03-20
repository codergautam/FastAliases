package com.codergautamyt.fastaliases.alias;

public class UnregisterAll {
    public static void UnregisterAllCommands() {
        if(AliasList.list != null) {
            for (Alias alias : AliasList.list) {
                alias.cmd.unregister(AliasList.commandMap);
            }
        }
        AliasList.clear();
    }
}
