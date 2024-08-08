package com.Team4.SWENG455.SWENG._5.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.RoomRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Room;



@RestController
public class RoomController {
	
	@Autowired
	RoomRepo roomRepo;
	
	@PostMapping("/addRoom")
	public void addRoom(@RequestBody Room room)
	{
		roomRepo.save(room);
	}
	
	@GetMapping("/getRoom/{id}") //indicates this class handles post requests
	public Room getRoom(@PathVariable Integer id) //specifies the class to put the data in
	{
		return roomRepo.findById(id).orElse(null);
	}

}
