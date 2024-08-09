package com.Team4.SWENG455.SWENG._5.Project.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.RoomRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.Room;
import com.Team4.SWENG455.SWENG._5.Project.model.User;



@RestController
public class RoomController {
	
	@Autowired
	RoomRepo roomRepo;
	
	@PostMapping("/addRoom")
	public void addRoom(@RequestBody Room room)
	{
		roomRepo.save(room);
	}
	
	@GetMapping("/getRoom/{id}") 
	public Room getRoom(@PathVariable Integer id)
	{
		return roomRepo.findById(id).orElse(null);
	}
	

	
	@PutMapping("/updateRoom") 
	public void updateRoom(@RequestBody Room room) 
	{
		Room data = roomRepo.findById(room.getRoomID()).orElse(null);
	
		if(data != null)
		{
			room.setCapacity(data.getCapacity());
			room.setName(data.getName());
			room.setRoomControl(data.getRoomControl());
			room.setRoomID(data.getRoomID());
			roomRepo.save(room);
		}
		
	}
	
	@GetMapping("/api/rooms")
    public ResponseEntity<List<Room>> fetchRooms() {
        List<Room> rooms = roomRepo.findAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteRoom/{id}") //the function takes in an id
	//Removed @PathVariable Integer id
	public void deleteRoom(Room room) {roomRepo.deleteById(room.getRoomID());}


    public void editRoom(Room room) {
		roomRepo.save(room);
    }

	public Room viewRoomDetails(Room room) {
		return roomRepo.findById(room.getRoomID()).orElse(null);
	}
}
