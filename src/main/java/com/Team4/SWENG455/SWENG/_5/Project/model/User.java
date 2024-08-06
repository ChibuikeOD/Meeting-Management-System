package com.Team4.SWENG455.SWENG._5.Project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    
    private String name;
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Meeting> meetings;
    
    @ManyToOne
    @JoinColumn(name = "controller_id")
    private Controller userControl;

   
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Controller getUserControl() {
        return userControl;
    }

    public void setUserControl(Controller userControl) {
        this.userControl = userControl;
    }
    
    public void login() {
       
    }

    public void logout() {
       
    }

    public void viewMeetings() {
        
    }

    public void updateProfile() {
       
    }
}
    
