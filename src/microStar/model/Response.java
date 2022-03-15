package microStar.model;

import java.io.Serializable;
import microStar.factory.SessionFactoryBuilder;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Response")
public class Response implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responseID")
    private int responseID; //Primary Key

    @Column(name = "complaintID")
    private int complaintID; //Foreign Key

    @Column(name = "proposedDateOfVisit")
    private LocalDateTime proposedDateOfVisit;

    @Column(name = "responseDetails")
    private String responseDetails;

    @Column(name = "responseDateTime")
    private LocalDateTime responseDateTime;

    @Column(name = "staffID")
    private String staffID; //Foreign Key //ID of Staff member that made Response

    public Response(){
        this.responseID = 0;
        this.complaintID = 0;
        this.proposedDateOfVisit = null;
        this.responseDetails = " ";
        this.responseDateTime = null;
        this.staffID = " ";
    }

    public Response(int responseID, int complaintID, LocalDateTime proposedDateOfVisit, String responseDetails, LocalDateTime responseDateTime, String staffID){
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

    public void setResponseID(int responseID) {
        this.responseID = responseID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public void setProposedDateOfVisit(LocalDateTime proposedDateOfVisit) {
        this.proposedDateOfVisit = proposedDateOfVisit;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public void setResponseDateTime(LocalDateTime responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public int getResponseID() {
        return responseID;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public LocalDateTime getProposedDateOfVisit() {
        return proposedDateOfVisit;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public LocalDateTime getResponseDateTime() {
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
