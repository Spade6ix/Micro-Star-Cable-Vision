package microStar.model;

import java.io.Serializable;

public class Complaint implements Serializable {
    private String complaintID;
    private String complaintType; //(Payment, Internet, Cable, Other)
    private String complaintDetails;
    private String lastResponderName;
    private String lastResponseDate;
    private char status; //(R/U)
    private String customerID; //(Foreign Key)
    private String staffID; //(Foreign Key)

    public Complaint(){
        this.complaintID = "";
        this.complaintType = "";
        this.complaintDetails = "";
        this.lastResponderName = "";
        this.lastResponseDate = "";
        this.status = 'R';
        this.customerID = "";
        this.staffID = "";
    }

    public Complaint(String complaintID, String complaintType, String complaintDetails, String lastResponderName, String lastResponseDate, char status, String customerID, String staffID) {
        this.complaintID = complaintID;
        this.complaintType = complaintType;
        this.complaintDetails = complaintDetails;
        this.lastResponderName = lastResponderName;
        this.lastResponseDate = lastResponseDate;
        this.status = status;
        this.customerID = customerID;
        this.staffID = staffID;
    }

    public Complaint(Complaint complaint) {
        this.complaintID = complaint.complaintID;
        this.complaintType = complaint.complaintType;
        this.complaintDetails = complaint.complaintDetails;
        this.lastResponderName = complaint.lastResponderName;
        this.lastResponseDate = complaint.lastResponseDate;
        this.status = complaint.status;
        this.customerID = complaint.customerID;
        this.staffID = complaint.staffID;
    }

    public String getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(String complaintID) {
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

    public String getLastResponderName() {
        return lastResponderName;
    }

    public void setLastResponderName(String lastResponderName) {
        this.lastResponderName = lastResponderName;
    }

    public String getLastResponseDate() {
        return lastResponseDate;
    }

    public void setLastResponseDate(String lastResponseDate) {
        this.lastResponseDate = lastResponseDate;
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
                + "Last Responder Name: " + lastResponderName + "\n"
                + "Last Response: " + lastResponseDate + "\n"
                + "Status: " + status + "\n" + "\n"
                + "Customer ID: " + customerID + "\n"
                + "Staff ID: " + staffID;
    }

}
