package microStar.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public Customer(){
        customerID = " ";
        password = " ";
        firstName = " ";
        lastName = " ";
        email = " ";
        phone = " ";
        address = " ";
    }

    public Customer(String customerID, String password, String firstName, String lastName, String email, String phone, String address){
        this.customerID = customerID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(Customer c){
        this.customerID = c.customerID;
        this.password = c.password;
        this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.email = c.email;
        this.phone = c.phone;
        this.address = c.address;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "Customer ID: " + customerID +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Address: " + address +
                '}';
    }

}
