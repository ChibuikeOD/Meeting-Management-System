package com.Team4.SWENG455.SWENG._5.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.UserRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

@RestController //annotation to indicate the class is a Controller
public class UserController {
	
	@Autowired //for dependency injection
	UserRepo userRepo;  //used to store, insert or fetch data from mongodb
	
	@PostMapping("/addUser") //indicates this class handles post requests
	public void addUser(@RequestBody User user) //specifies the class to put the data in
	{
		userRepo.save(user);
	}
	
	@GetMapping("/getUser/{id}") 
	public User getUser(@PathVariable Integer id) 
	{
		return userRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/fetchUsers") 
	public List<User> fetchUsers() 
	{
		return userRepo.findAll();
	}
	
	@PutMapping("/updateUser") 
	public void updateUser(@RequestBody User user)
	{
		User data = userRepo.findById(user.getUserID()).orElse(null);
	
		if(data != null)
		{
			user.setName(data.getName());
			user.setEmail(data.getEmail());
			user.setMeetings(data.getMeetings());
			user.setPassword(data.getPassword());
			user.setUserControl(data.getUserControl());
			user.setMeetings(data.getMeetings());
			userRepo.save(user);
		}
		
	}
	
	@DeleteMapping("/deleteUser/{id}") //the function takes in an id
	public void deleteUser(@PathVariable Integer id) 
	{
		userRepo.deleteById(id);
	}


	public boolean validateCredentials(String email, String password) {
		User user = userRepo.findByEmail(email);
		return user != null && user.getPassword().equals(password);
	}

	public List<Meeting> getUserMeetings(Integer userID) {
		User user = userRepo.findById(userID).orElse(null);
		return user != null ? user.getMeetings() : null;
	}

}
