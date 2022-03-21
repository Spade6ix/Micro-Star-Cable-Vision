package microStar.employee;

import microStar.customer.CustomerController;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeController {
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    public static void main(String[] args) {
        try{


        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        finally {
            
        }
    }
}
