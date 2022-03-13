package microStar.model;

import java.io.Serializable;
import microStar.factory.DBConnectorFactory;

public class Query implements Serializable{
    private String customerID; //Primary Key & Foreign Key
    private String paymentStatus;
    private Double amountDue;
    private String dueDate;

    public Query(){
        this.customerID= " ";
        this.paymentStatus = " ";
        this.amountDue = 0.00;
        this.dueDate = " ";
    }

    public Query(String customerID, String paymentStatus, Double amountDue, String dueDate){
        this.customerID = customerID;
        this.paymentStatus = paymentStatus;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
    }

    public Query(Query q){
        this.customerID = q.customerID;
        this.paymentStatus = q.paymentStatus;
        this.amountDue = q.amountDue;
        this.dueDate = q.dueDate;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setAmountDue(Double amountDue) {
        this.amountDue = amountDue;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Double getAmountDue() {
        return amountDue;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Query{" +
                "CustomerID: " + customerID +
                ", Payment Status: " + paymentStatus +
                ", Amount Due: " + amountDue +
                ", Due Date: " + dueDate +
                '}';
    }
}
