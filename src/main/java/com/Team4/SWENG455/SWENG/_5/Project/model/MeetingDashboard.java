package com.Team4.SWENG455.SWENG._5.Project.model;

import com.Team4.SWENG455.SWENG._5.Project.Repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MeetingDashboard {

    @Autowired
    private MeetingRepo MeetingRepo;

    public List<Meeting> loadMeetings() {
        return MeetingRepo.findAll();
    }

    public Meeting viewMeetingDetails(String meetingID) {
        Optional<Meeting> meeting = MeetingRepo.findById(Integer.parseInt(meetingID));
        return meeting.orElse(null);
    }

    public void cancelMeeting(String meetingID) {
        Optional<Meeting> meeting = MeetingRepo.findById(Integer.parseInt(meetingID));
        if (meeting.isPresent()) {
            MeetingRepo.delete(meeting.get());
        }
    }

    public Meeting scheduleNewMeeting(Meeting meeting) {
        return MeetingRepo.save(meeting);
    }
}
