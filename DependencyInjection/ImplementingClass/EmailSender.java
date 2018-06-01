package ImplementingClass;

import Interface.IEmailer;

public class EmailSender implements IEmailer {
    @Override
    public void send(String message) {
        System.out.println(message + " has been send via email.");
    }
}
