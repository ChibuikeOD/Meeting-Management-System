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
import com.Team4.SWENG455.SWENG._5.Project.Repository.MeetingRepo;

import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;


@RestController
public class MeetingController {
	
	@Autowired
	MeetingRepo meetRepo;

	@PostMapping("/addMeeting")
	public void addMeeting(@RequestBody Meeting meeting) 
	{
		meetRepo.save(meeting);
	}
	
	@GetMapping("/getMeeting/{id}")
	public Meeting getMeeting(@PathVariable Integer id) 
	{
		return meetRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/fetchMeetings") 
	public List<Meeting> fetchMeetings() 
	{
		return meetRepo.findAll();
	}
	
	@PutMapping("/updateMeeting")
	public void updateMeeting(@RequestBody Meeting meet) 
	{
		Meeting data = meetRepo.findById(meet.getMeetingID()).orElse(null);
	
		if(data != null)
		{
			meet.setDescription(data.getDescription());
			meet.setEndTime(data.getEndTime());
			meet.setStartTime(data.getStartTime());
			meet.setTitle(data.getEndTime());
			meet.setMeetingID(data.getMeetingID());
		
			meetRepo.save(meet);
		}
		
	}
	
	@DeleteMapping("/deleteMeeting/{id}") //the function takes in an id
	public void deleteMeeting(@PathVariable Integer id) 
	{
		meetRepo.deleteById(id);
	}

}
