package microStar.customer;

import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    public static void main(String[] args) {
        try{


        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        finally {
            SessionFactoryBuilder.closeSessionFactory();
            DBConnectorFactory.closeDatabaseConnection();
            logger.info("Database Connections Closed");
        }
    }
}
