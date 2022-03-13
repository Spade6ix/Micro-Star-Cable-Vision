package microStar.model;

import java.io.Serializable;
import microStar.factory.DBConnectorFactory;

public class CustomerPhone implements Serializable {
    private String phone; //Primary Key
    private String customerID; //Primary Key & Foreign Key

    public CustomerPhone(){
        this.phone = " ";
        this.customerID = " ";
    }

    public CustomerPhone(String phone, String customerID){
        this.phone = phone;
        this.customerID = customerID;
    }

    public CustomerPhone(CustomerPhone p){
        this.phone = p.phone;
        this.customerID = p.customerID;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getphone() {
        return phone;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return "CustomerPhone{" +
                "Phone: " + phone +
                ", Customer ID: " + customerID +
                '}';
    }
}
