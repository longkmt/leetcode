package ImplementingClass;

import Interface.ILogger;

public class Logger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message + " has been logged.");
    }
}
