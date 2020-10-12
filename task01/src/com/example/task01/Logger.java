package com.example.task01;

import sun.rmi.runtime.Log;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Logger {
    public static HashMap<String, Logger> loggerList = new HashMap();

    private Levels level = Levels.DEBUG;

    private String name;

    public enum Levels{
        DEBUG(1),
        INFO(2),
        WARNING(3),
        ERROR(4);

        private final int value;

        private Levels(int value) { this.value = value; }
        public static boolean isBiggerOrEqual(Levels level1, Levels level2){
            return level1.intValue()>=level2.intValue();
        }
        private int intValue() {
            return value;
        }
    }

    private Logger(String name){
        this.name = name;
    }
    private static Logger setToList(String name){
        Logger logger = new Logger(name);
        logger.setLevel(Levels.DEBUG);
        loggerList.put(logger.name, logger);
        return logger;
    }

    public static Logger getLogger(String name){
        if(loggerList.containsKey(name)) return loggerList.get(name);
        return setToList(name);
    }

    public String getName(){
        return name;
    }

    public void setLevel(Levels level){
        this.level = level;
    }

    public Levels getLevel(){
        return level;
    }

    public void log(Levels level, String msg){
        if (Levels.isBiggerOrEqual(level, this.level)){
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level, new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime()), name, msg));
        }
    }
    private void log(Levels level, String format, Object... args) {
        log(level, MessageFormat.format(format, args));
    }
    public void debug(String message) {
        log(Levels.DEBUG, message);
    }

    public void debug(String format, Object... args) {
        log(Levels.DEBUG, format, args);
    }

    public void info(String message) {
        log(Levels.INFO, message);
    }

    public void info(String format, Object... args) {
        log(Levels.INFO, format, args);
    }

    public void warning(String message) {
        log(Levels.WARNING, message);
    }

    public void warning(String format, Object... args) {
        log(Levels.WARNING, format, args);
    }

    public void error(String message) {
        log(Levels.ERROR, message);
    }

    public void error(String format, Object... args) {
        log(Levels.ERROR, format, args);
    }

}
