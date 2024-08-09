package com.Team4.SWENG455.SWENG._5.Project.Controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.UserRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Admin;
import com.Team4.SWENG455.SWENG._5.Project.model.Client;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

import jakarta.servlet.http.HttpSession;

@RestController //annotation to indicate the class is a Controller
public class UserController {
	
	@Autowired //for dependency injection
	UserRepo userRepo;  //used to store, insert or fetch data from mongodb
	
	@PostMapping("/register")
	public ResponseEntity<String> register(
	        @RequestParam("firstName") String firstName,
	        @RequestParam("lastName") String lastName,
	        @RequestParam("email") String email,
	        @RequestParam("password") String password,
	        @RequestParam("accountType") String accountType) {

	    try {
	        User user = new User();

	        // Check the account type and instantiate the appropriate class
	        if ("admin".equalsIgnoreCase(accountType)) {
	            user.setAdmin(true);
	        } else {
	            user.setAdmin(false);  // Default to Client if not admin
	        }
	        System.out.println(accountType);
	        // Set common properties
	        user.setUserID(UUID.randomUUID().toString()); // Generate unique ID
	        String name = firstName + " " + lastName;
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(password);

	        // Save the user to the repository
	        userRepo.save(user);
	        System.out.println("Saved user: " + user.getName());
	        
	        return ResponseEntity.status(HttpStatus.FOUND)
	                .location(URI.create("/login.html"))
	                .build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Failed to register user", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
		
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(
	        @RequestParam("email") String email,
	        @RequestParam("password") String password,
	        HttpSession session) {

	    try {
	        Optional<User> optionalUser = userRepo.findByEmail(email);

	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();

	            if (user.getPassword().equals(password)) {
	                // Store the user in the session
	                session.setAttribute("loggedInUser", user);

	                // Redirect to home.html on successful login
	                return ResponseEntity.status(HttpStatus.FOUND)
	                                     .location(URI.create("/home"))
	                                     .build();
	            } else {
	                // Redirect back to login page with an error query parameter
	                return ResponseEntity.status(HttpStatus.FOUND)
	                                     .location(URI.create("/login.html?error=true"))
	                                     .build();
	            }
	        } else {
	            // Redirect back to login page with an error query parameter
	            return ResponseEntity.status(HttpStatus.FOUND)
	                                 .location(URI.create("/login.html?error=true"))
	                                 .build();
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/profile")
	public String getProfile(HttpSession session, Model model) {
	    User loggedInUser = (User) session.getAttribute("loggedInUser");
	    
	    if (loggedInUser != null) {
	        model.addAttribute("user", loggedInUser);
	        return "profile";
	    } else {
	        return "redirect:/login.html";
	    }
	}
	
//	@GetMapping("/home")
//	public ResponseEntity<Void> homePage(HttpSession session) {
//	    User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//	    if (loggedInUser instanceof Admin) {
//	        return ResponseEntity.status(HttpStatus.FOUND)
//	                             .location(URI.create("/home-admin.html"))
//	                             .build();
//	    } else {
//	        return ResponseEntity.status(HttpStatus.FOUND)
//	                             .location(URI.create("/home.html"))
//	                             .build();
//	    }
//	}



	
	@GetMapping("/fetchUsers") 
	public List<User> fetchUsers() 
	{
		return userRepo.findAll();
	}
	
//	@PutMapping("/updateUser") 
//	public void updateUser(@RequestBody User user)
//	{
//		User data = userRepo.findById(user.getUserID()).orElse(null);
//	
//		if(data != null)
//		{
//			user.setName(data.getName());
//			user.setEmail(data.getEmail());
//			user.setMeetings(data.getMeetings());
//			user.setPassword(data.getPassword());
//			user.setUserControl(data.getUserControl());
//			user.setMeetings(data.getMeetings());
//			userRepo.save(user);
//		}
//		
//	}
	
//	@DeleteMapping("/deleteUser/{id}") //the function takes in an id
//	public void deleteUser(@PathVariable Integer id) 
//	{
//		userRepo.deleteById(id);
//	}


//	public boolean validateCredentials(String email, String password) {
//		User user = userRepo.findByEmail(email);
//		return user != null && user.getPassword().equals(password);
//	}

//	public List<Meeting> getUserMeetings(String userID) {
//		User user = userRepo.findById(userID).orElse(null);
//		return user != null ? user.getMeetings() : null;
//	}

}
