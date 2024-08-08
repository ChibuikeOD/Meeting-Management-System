package com.Team4.SWENG455.SWENG._5.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.UserRepo;
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

}
