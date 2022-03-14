package microStar.model;

import java.io.Serializable;
import microStar.factory.SessionFactoryBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Complaint")
public class Complaint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaintID")
    private int complaintID; //Primary Key

    @Column(name = "complaintType")
    private String complaintType; //(Payment, Internet, Cable, Other)

    @Column(name = "complaintDetails")
    private String complaintDetails;

    @Column(name = "status")
    private char status; //(R/U)

    @Column(name = "customerID")
    private String customerID; //(Foreign Key)

    @Column(name = "staffID")
    private String staffID; //(Foreign Key) //TechnicianID

    public Complaint(){
        this.complaintID = 0;
        this.complaintType = "";
        this.complaintDetails = "";
        this.status = 'U';
        this.customerID = "";
        this.staffID = "";
    }

    public Complaint(int complaintID, String complaintType, String complaintDetails, char status, String customerID, String staffID) {
        this.complaintID = complaintID;
        this.complaintType = complaintType;
        this.complaintDetails = complaintDetails;
        this.status = status;
        this.customerID = customerID;
        this.staffID = staffID;
    }

    public Complaint(Complaint complaint) {
        this.complaintID = complaint.complaintID;
        this.complaintType = complaint.complaintType;
        this.complaintDetails = complaint.complaintDetails;
        this.status = complaint.status;
        this.customerID = complaint.customerID;
        this.staffID = complaint.staffID;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String toString() {
        return "Complaint ID: " + complaintID + "\n"
                + "Complaint Type: " + complaintType + "\n"
                + "Complaint Detail: " + complaintDetails + "\n"
                + "Status: " + status + "\n"
                + "Customer ID: " + customerID + "\n"
                + "Staff ID: " + staffID;
    }

}
