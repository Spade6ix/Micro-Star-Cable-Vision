package microStar.employee;

import microStar.customer.CustomerClient;
import microStar.customer.CustomerController;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.Customer;
import microStar.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeController {
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);
    public static EmployeeClient empClient;
    public static Employee e;

    public EmployeeController(){
        empClient = new EmployeeClient();
        e = new Employee();
    }

    /*public static void main(String[] args) {
        try{

        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        finally {
            
        }
    }*/
}
