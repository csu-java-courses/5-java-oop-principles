package com.example.task01;
public class Task01Main {
    public static void main(String[] args) {
        Logger testLogger = Logger.getLogger("test");
        testLogger.setLevel(Logger.Levels.ERROR);
        testLogger.log(Logger.Levels.ERROR, "abc");
    }
}
