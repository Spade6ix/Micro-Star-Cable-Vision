package microStar.model;

import java.io.Serializable;

public class Response implements Serializable {
    private String responseID;
    private String complaintID;
    private String proposedDateOfVisit;
    private String responseDetails;
    private String responseDateTime;
    private String staffID;

    public Response(){
        this.responseID = " ";
        this.complaintID = " ";
        this.proposedDateOfVisit = " ";
        this.responseDetails = " ";
        this.responseDateTime = " ";
        this.staffID = " ";
    }

    public Response(String responseID, String complaintID, String proposedDateOfVisit, String responseDetails, String responseDateTime, String staffID){
        this.responseID = responseID;
        this.complaintID = complaintID;
        this.proposedDateOfVisit = proposedDateOfVisit;
        this.responseDetails = responseDetails;
        this.responseDateTime = responseDateTime;
        this.staffID = staffID;
    }

    public Response(Response r){
        this.responseID = r.responseID;
        this.complaintID = r.complaintID;
        this.proposedDateOfVisit = r.proposedDateOfVisit;
        this.responseDetails = r.responseDetails;
        this.responseDateTime = r.responseDateTime;
        this.staffID = r.staffID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public void setComplaintID(String complaintID) {
        this.complaintID = complaintID;
    }

    public void setProposedDateOfVisit(String proposedDateOfVisit) {
        this.proposedDateOfVisit = proposedDateOfVisit;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getResponseID() {
        return responseID;
    }

    public String getComplaintID() {
        return complaintID;
    }

    public String getProposedDateOfVisit() {
        return proposedDateOfVisit;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public String getStaffID() {
        return staffID;
    }

    @Override
    public String toString() {
        return "Response{" +
                "Response ID: " + responseID +
                ", Complaint ID: " + complaintID +
                ", Proposed Date Of Visit: " + proposedDateOfVisit +
                ", Response Details: " + responseDetails +
                ", Response Date & Time: " + responseDateTime +
                ", Staff ID: " + staffID +
                '}';
    }
}
