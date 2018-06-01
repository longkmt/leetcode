package Mock;

import Interface.IEmailer;

public class TestEmailSender implements IEmailer {
    @Override
    public void send(String message) {
        System.out.println(message + " has been emailed by TestEmailSender.");
    }
}
