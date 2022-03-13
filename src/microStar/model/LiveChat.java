package microStar.model;

import java.io.Serializable;
import microStar.factory.DBConnectorFactory;

public class LiveChat implements Serializable{
    private int liveChatID; // Primary Key
    private String customerID; //Foreign Key
    private String staffID; //Foreign Key
    private String message;

    public LiveChat(){
        this.liveChatID = 0;
        this.customerID = " ";
        this.staffID = " ";
        this.message = " ";
    }

    public LiveChat(int liveChatID, String customerID, String staffID, String message){
        this.liveChatID = liveChatID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.message = message;
    }

    public LiveChat(LiveChat l){
        this.liveChatID = l.liveChatID;
        this.customerID = l.customerID;
        this.staffID = l.staffID;
        this.message = l.message;
    }

    public void setLiveChatID(int liveChatID) {
        this.liveChatID = liveChatID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getMessage() {
        return message;
    }

    public int getLiveChatID() {
        return liveChatID;
    }

    @Override
    public String toString() {
        return "LiveChat{" +
                "Customer ID: " + customerID +
                ", Staff ID: " + staffID +
                ", Message: " + message +
                '}';
    }
}
