package com.Team4.SWENG455.SWENG._5.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Complaint;

@RestController
public class ComplaintController {
	
	@Autowired
	ComplaintRepo compRepo;
	
	@PostMapping("/addComplaint")
	public void addComplaint(@RequestBody Complaint comp)
	{
		compRepo.save(comp);
	}

}
