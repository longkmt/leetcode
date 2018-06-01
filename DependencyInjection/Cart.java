import Interface.IDatabase;
import Interface.IEmailer;
import Interface.ILogger;

public class Cart {

    private IEmailer emailSender;
    private ILogger logger;
    private IDatabase databaseWriter;

    public Cart(IEmailer _emailSender, ILogger _logger, IDatabase _databaseWriter){
        this.emailSender = _emailSender;
        this.logger = _logger;
        this.databaseWriter = _databaseWriter;
    }

    public void checkout(){
        emailSender.send("SOS signal");
        logger.log("SOS signal");
        databaseWriter.write("SOS signal");
    }
}
