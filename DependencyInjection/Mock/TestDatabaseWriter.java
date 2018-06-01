package Mock;

import Interface.IDatabase;

public class TestDatabaseWriter implements IDatabase {
    @Override
    public void write(String message) {
        System.out.println(message + " has been sent by TestDatabaseWriter");
    }
}
