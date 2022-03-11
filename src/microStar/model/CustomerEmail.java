package microStar.model;

import java.io.Serializable;

public class CustomerEmail implements Serializable {
    private String email;
    private String customerID;

    public CustomerEmail(){
        this.email = " ";
        this.customerID = " ";
    }

    public CustomerEmail(String email, String customerID){
        this.email = email;
        this.customerID = customerID;
    }

    public CustomerEmail(CustomerEmail e){
        this.email = e.email;
        this.customerID = e.customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public String toString() {
        return "CustomerEmail{" +
                "Email: " + email +
                ", Customer ID: " + customerID +
                '}';
    }
}
