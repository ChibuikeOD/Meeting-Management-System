package com.Team4.SWENG455.SWENG._5.Project.model;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomID;
    
    private String name;
    private int capacity;
    
   
    private Controller roomControl;

   
    
    public void addRoom() {
       
    }

    public void editRoom() {
        
    }

    public void deleteRoom() {
        
    }

    public void viewRoomDetails() {
       
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

    public Controller getRoomControl() {
        return roomControl;
    }

    public void setRoomControl(Controller roomControl) {
        this.roomControl = roomControl;
    }

}
