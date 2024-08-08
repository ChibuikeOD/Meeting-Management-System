package com.Team4.SWENG455.SWENG._5.Project.model;
import org.springframework.data.mongodb.core.mapping.*;

import com.Team4.SWENG455.SWENG._5.Project.Controller.ComplaintController;

import org.springframework.data.annotation.*;



@Document
public class Complaint {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintID;
    
    private int userID;
    private String description;
    private String status;
    
    
    private Room room;
  
    private ComplaintController complaintControl;

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ComplaintController getComplaintControl() {
        return complaintControl;
    }

    public void setComplaintControl(ComplaintController complaintControl) {
        this.complaintControl = complaintControl;
    }

    public void addComplaint() {
       
    }

    public void editComplaint() {
        
    }

    public void deleteComplaint() {
       
    }

    public void viewComplaintDetails() {
        
    }
}
