package microStar.customer;

import java.io.Serializable;

public class Payment implements Serializable {
    private String paymentID;
    private String paymentStatus;
    private Double amountDue;
    private String dueDate;
    private String customerID;
    private String dateOfPayment;
    private Double amountPaid;

    public Payment(){
        this.paymentID = " ";
        this.paymentStatus = " ";
        this.amountDue = 0.00;
        this.dueDate = " ";
        this.customerID = " ";
        this.dateOfPayment = " ";
        this.amountPaid = 0.00;
    }

    public Payment(String paymentID, String paymentStatus, Double amountDue, String dueDate, String customerID, String dateOfPayment, Double amountPaid){
        this.paymentID = paymentID;
        this.paymentStatus = paymentStatus;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.customerID = customerID;
        this.dateOfPayment = dateOfPayment;
        this.amountPaid = amountPaid;
    }

    public Payment(Payment p){
        this.paymentID = p.paymentID;
        this.paymentStatus = p.paymentStatus;
        this.amountDue = p.amountDue;
        this.dueDate = p.dueDate;
        this.customerID = p.customerID;
        this.dateOfPayment = p.dateOfPayment;
        this.amountPaid = p.amountPaid;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentID() {
        return paymentID;
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

    public String getCustomerID() {
        return customerID;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "Payment ID: " + paymentID +
                ", Payment Status: " + paymentStatus +
                ", Amount Due: " + amountDue +
                ", Due Date: " + dueDate +
                ", Customer ID: " + customerID +
                ", Date Of Payment: " + dateOfPayment +
                ", Amount Paid: " + amountPaid +
                '}';
    }
}
