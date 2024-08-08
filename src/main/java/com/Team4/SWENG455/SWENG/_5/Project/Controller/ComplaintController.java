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

import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Complaint;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

@RestController
public class ComplaintController {
	
	@Autowired
	ComplaintRepo compRepo;
	
	@PostMapping("/addComplaint")
	public void addComplaint(@RequestBody Complaint comp)
	{
		compRepo.save(comp);
	}
	
	@GetMapping("/getComplaint/{id}") 
	public Complaint getComplaint(@PathVariable Integer id) 
	{
		return compRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/fetchComplaints") 
	public List<Complaint> fetchComplaints() 
	{
		return compRepo.findAll();
	}
	
	@PutMapping("/updateComplaint") 
	public void updateComplaint(@RequestBody Complaint comp) 
	{
		Complaint data = compRepo.findById(comp.getComplaintID()).orElse(null);
	
		if(data != null)
		{
			comp.setComplaintControl(data.getComplaintControl());
			comp.setComplaintID(data.getComplaintID());
			comp.setDescription(data.getDescription());
			comp.setRoom(data.getRoom());
			comp.setStatus(data.getStatus());
			comp.setUserID(data.getUserID());
			compRepo.save(comp);
		}
		
	}
	
	@DeleteMapping("/deleteComplaint/{id}") //the function takes in an id
	public void deleteComplaint(@PathVariable Integer id) 
	{
		compRepo.deleteById(id);
	}


}
