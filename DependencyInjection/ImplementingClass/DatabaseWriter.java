package ImplementingClass;

import Interface.IDatabase;

public class DatabaseWriter implements IDatabase {

    @Override
    public void write(String message) {
        System.out.println(message + " has been written to the db.");
    }
}
