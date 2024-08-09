package com.Team4.SWENG455.SWENG._5.Project.model;
import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;
import com.Team4.SWENG455.SWENG._5.Project.Repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Client extends User {
    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private ComplaintRepo complaintRepo;

    public void createMeeting(Meeting meeting) {

        meetingRepo.save(meeting);
    }

    public void editMeeting(Meeting meeting) {

        meetingRepo.save(meeting);
    }

	/*
	 * public void deleteMeeting(Integer meetingId) {
	 * 
	 * meetingRepo.deleteById(meetingId); }
	 */
    public void fileComplaint(Complaint complaint) {

        complaintRepo.save(complaint);
    }
    
    public boolean isAdmin() {
        return false;
    }
}