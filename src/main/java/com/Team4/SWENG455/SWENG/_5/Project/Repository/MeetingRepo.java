package com.Team4.SWENG455.SWENG._5.Project.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;


public interface MeetingRepo extends MongoRepository<Meeting, String>{

}
