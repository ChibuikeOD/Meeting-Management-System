package com.Team4.SWENG455.SWENG._5.Project.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.*;

import com.Team4.SWENG455.SWENG._5.Project.Controller.RoomController;

import org.springframework.data.annotation.*;


@Document
public class Room {
  
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Integer roomID;
    
    private String name;
    private int capacity;


    @Autowired
    private RoomController roomControl;

   
    
    public void addRoom() {
        if (roomControl != null) {
            roomControl.addRoom(this);
        } else {
            throw new IllegalStateException("RoomController is not set.");
        }
    }

    public void editRoom() {
        if (roomControl != null) {
            roomControl.editRoom(this);
        } else {
            throw new IllegalStateException("RoomController is not set.");
        }
    }

    public void deleteRoom() {
        if (roomControl != null) {
            roomControl.deleteRoom(this);
        } else {
            throw new IllegalStateException("RoomController is not set.");
        }
    }


    public void viewRoomDetails() {
        if (roomControl != null) {
            roomControl.viewRoomDetails(this);
        } else {
            throw new IllegalStateException("RoomController is not set.");
        }
    }
    
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RoomController getRoomControl() {
        return roomControl;
    }

    public void setRoomControl(RoomController roomControl) {
        this.roomControl = roomControl;
    }

}
