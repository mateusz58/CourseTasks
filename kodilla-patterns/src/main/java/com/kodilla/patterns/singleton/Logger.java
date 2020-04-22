package com.kodilla.patterns.singleton;

public class Logger {
    private String lastLog = "";
    private static Logger loggerInstance;

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized(Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public void resetLogs(){
        this.lastLog = "";
    }

    public String getLastLog() {
        return lastLog;
    }

    public void setLastLog(final String lastLog) {
        this.lastLog = lastLog;
    }
}
