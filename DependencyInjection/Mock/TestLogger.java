package Mock;

import Interface.ILogger;

public class TestLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message + " has been logged by TestLogger");

    }
}
