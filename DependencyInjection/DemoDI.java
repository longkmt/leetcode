import ImplementingClass.DatabaseWriter;
import ImplementingClass.EmailSender;
import ImplementingClass.Logger;
import Interface.IDatabase;
import Interface.IEmailer;
import Interface.ILogger;
import Mock.TestDatabaseWriter;
import Mock.TestEmailSender;
import Mock.TestLogger;

public class DemoDI {


    public static void main(String[] args) throws Exception {

        DIContainer.setModule(IDatabase.class, DatabaseWriter.class);
        DIContainer.setModule(ILogger.class, Logger.class);
        DIContainer.setModule(IEmailer.class, EmailSender.class);
        DIContainer.setModule(Cart.class,Cart.class);

        Object cart = DIContainer.getModule(Cart.class);
        ((Cart) cart).checkout();

        //now see if we can inject different classes into Cart
        DIContainer.setModule(IDatabase.class, TestDatabaseWriter.class);
        DIContainer.setModule(ILogger.class, TestLogger.class);
        DIContainer.setModule(IEmailer.class, TestEmailSender.class);
        DIContainer.setModule(Cart.class,Cart.class);

        cart = DIContainer.getModule(Cart.class);
        ((Cart) cart).checkout();
    }
}
