package microStar.customer;


import com.mysql.cj.xdevapi.Client;
import microStar.factory.DBConnectorFactory;
import microStar.factory.SessionFactoryBuilder;
import microStar.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    public static void main(String[] args) {
        try{
            CustomerClient client = new CustomerClient();
            Customer c = new Customer();
            c.setCustomerID("B4955");
            c.setPassword("agnus35");
            client.sendAction("Customer Login");
            client.sendCustomerObj(c);
            client.receiveResponse();
            if(client.isLogin()){
                System.out.println("\nSUCCESS!!!!");
            }
            else{
                System.out.println("\nFailure!!!!");
            }
            client.sendAction("");

        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("Exception Occurred");
        }
        finally{

        }
    }
}
