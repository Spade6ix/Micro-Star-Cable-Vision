package microStar.model;

import java.io.Serializable;
import microStar.factory.SessionFactoryBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment implements Serializable {
    @Column(name = "paymentID")
    private String paymentID; //Primary Key

    @Column(name = "customerID")
    private String customerID; //Foreign Key

    @Column(name = "dateOfPayment")
    private String dateOfPayment;

    @Column(name = "amountPaid")
    private Double amountPaid;

    public Payment(){
        this.paymentID = " ";
        this.customerID = " ";
        this.dateOfPayment = " ";
        this.amountPaid = 0.00;
    }

    public Payment(String paymentID, String customerID, String dateOfPayment, Double amountPaid){
        this.paymentID = paymentID;
        this.customerID = customerID;
        this.dateOfPayment = dateOfPayment;
        this.amountPaid = amountPaid;
    }

    public Payment(Payment p){
        this.paymentID = p.paymentID;
        this.customerID = p.customerID;
        this.dateOfPayment = p.dateOfPayment;
        this.amountPaid = p.amountPaid;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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
                ", Customer ID: " + customerID +
                ", Date Of Payment: " + dateOfPayment +
                ", Amount Paid: " + amountPaid +
                '}';
    }
}
