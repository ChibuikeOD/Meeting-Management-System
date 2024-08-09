package com.Team4.SWENG455.SWENG._5.Project.model;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import com.Team4.SWENG455.SWENG._5.Project.Controller.UserController;

import java.util.List;

@Document(collection = "user")
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private String userID;
    
    private String name;
    private String email;
    private String password;
    
//    @OneToMany(mappedBy = "user")
    private List<Meeting> meetings;
    
//    @ManyToOne
//    @JoinColumn(name = "controller_id")
    private UserController userControl;

   
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public UserController getUserControl() {
        return userControl;
    }

    public void setUserControl(UserController userControl) {
        this.userControl = userControl;
    }
    
//    public boolean login(String username, String password) {
//        return userControl.validateCredentials(email, password);
//    }

    public void logout() {
       //needs to log out / clearing session or authentication
    }

//    public List<Meeting> viewMeetings() {
//        return userControl.getUserMeetings(userID);
//    }

//    public void updateProfile(String name, String email, String password) {
//       this.name = name;
//       this.email = email;
//       this.password = password;
//
//       userControl.updateUser(this);
//    }
}
    
