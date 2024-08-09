package com.Team4.SWENG455.SWENG._5.Project.Controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Complaint;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class ComplaintController {
	
	@Autowired
	ComplaintRepo compRepo;
	
	@PostMapping("/addComplaint")
	public void addComplaint(@RequestBody Complaint comp)
	{
		compRepo.save(comp);
	}
	
	 @PostMapping("/createComplaint")
	    public ResponseEntity<Void> createComplaint(
	            @RequestParam("description") String description,
	            HttpSession session) {

	        // Get the logged-in user from the session
	        User loggedInUser = (User) session.getAttribute("loggedInUser");

	        if (loggedInUser == null) {
	            // Redirect to login page if no user is logged in
	            return ResponseEntity.status(HttpStatus.FOUND)
	                                 .location(URI.create("/login.html"))
	                                 .build();
	        }

	        // Create a new Complaint object
	        Complaint complaint = new Complaint();
	        complaint.setDescription(description);
	        complaint.setUserID(loggedInUser.getUserID()); // Set the userID to the logged-in user's ID
	        complaint.setStatus("New"); // Set a default status for the complaint
	        System.out.println(complaint.getDescription());
	        // Save the complaint to the database
	        compRepo.save(complaint);

	        // Redirect to a confirmation page or back to the complaint page
	        return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/complaint.html"))
                    .build();
	    }
	
//	@GetMapping("/getComplaint/{id}") 
//	public Complaint getComplaint(@PathVariable Integer id) 
//	{
//		return compRepo.findById(id).orElse(null);
//	}
	
	@GetMapping("/fetchComplaints") 
	public List<Complaint> fetchComplaints() 
	{
		return compRepo.findAll();
	}
	
//	@PutMapping("/updateComplaint") 
//	public void updateComplaint(@RequestBody Complaint comp) 
//	{
//		Complaint data = compRepo.findById(comp.getComplaintID()).orElse(null);
//	
//		if(data != null)
//		{
//			comp.setComplaintControl(data.getComplaintControl());
//			comp.setComplaintID(data.getComplaintID());
//			comp.setDescription(data.getDescription());
//			comp.setRoom(data.getRoom());
//			comp.setStatus(data.getStatus());
//			comp.setUserID(data.getUserID());
//			compRepo.save(comp);
//		}
//		
//	}
	
//	@DeleteMapping("/deleteComplaint/{id}") //the function takes in an id
//	public void deleteComplaint(@PathVariable Integer id) 
//	{
//		compRepo.deleteById(id);
//	}


}
