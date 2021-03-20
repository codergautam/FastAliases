package com.codergautamyt.fastaliases.alias;

public class Alias {
    String alias;
    Executor cmd;
    Alias(String ali, Executor command) {
        this.alias = ali;
        this.cmd = command;
    }
}
