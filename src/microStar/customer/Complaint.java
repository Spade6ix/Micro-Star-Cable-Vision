package microStar.customer;

import java.io.Serializable;

public class Complaint implements Serializable {
    private String complaintID;
    private String complaintType; //(Payment, Internet, Cable, Other)
    private String complaintDetails;
    private String responder;
    private String lastResponse;
    private char status; //(R/U)
    private String customerID; //(Foreign Key)
    private String staffID; //(Foreign Key)

    public Complaint(){
        this.complaintID = "";
        this.complaintType = "";
        this.complaintDetails = "";
        this.responder = "";
        this.lastResponse = "";
        this.status = 'R';
        this.customerID = "";
        this.staffID = "";
    }

    public Complaint(String complaintID, String complaintType, String complaintDetails, String responder, String lastResponse, char status, String customerID, String staffID) {
        this.complaintID = complaintID;
        this.complaintType = complaintType;
        this.complaintDetails = complaintDetails;
        this.responder = responder;
        this.lastResponse = lastResponse;
        this.status = status;
        this.customerID = customerID;
        this.staffID = staffID;
    }

    public Complaint(Complaint complaint) {
        this.complaintID = complaint.complaintID;
        this.complaintType = complaint.complaintType;
        this.complaintDetails = complaint.complaintDetails;
        this.responder = complaint.responder;
        this.lastResponse = complaint.lastResponse;
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

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getLastResponse() {
        return lastResponse;
    }

    public void setLastResponse(String lastResponse) {
        this.lastResponse = lastResponse;
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
                + "Responder: " + responder + "\n"
                + "Last Response: " + lastResponse + "\n"
                + "Status: " + status + "\n" + "\n"
                + "Customer ID: " + customerID + "\n"
                + "Staff ID: " + staffID;
    }

}
