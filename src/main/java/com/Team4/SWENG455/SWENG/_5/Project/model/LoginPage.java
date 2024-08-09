package com.Team4.SWENG455.SWENG._5.Project.model;

import com.Team4.SWENG455.SWENG._5.Project.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPage extends GenericForm{

    private String username;
    private String password;

    @Autowired
    private UserRepo userRepo;

    public void setUsername(String username) {
       this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateCredentials() {

        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

     //   User user = UserRepo.findusername(username);

       return false;


    }
    @Override
    public boolean validate() {

        return validateCredentials();
    }
    @Override
    public void submit() {
        if (validate()) {

        } else {

        }
    }
}
