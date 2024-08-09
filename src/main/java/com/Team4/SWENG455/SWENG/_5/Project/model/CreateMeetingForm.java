package com.Team4.SWENG455.SWENG._5.Project.model;

import com.Team4.SWENG455.SWENG._5.Project.Repository.MeetingRepo;

public class CreateMeetingForm extends GenericForm {
    private Meeting meetingDetails;

    public Meeting getMeetingDetails() {
        return meetingDetails;
    }

    public CreateMeetingForm(Meeting meetingDetails) {
        this.meetingDetails = meetingDetails;
    }

    public void setMeetingDetails(Meeting meetingDetails){
        this.meetingDetails = meetingDetails;
    }
    @Override
    public boolean validate() {

        if (meetingDetails == null) {
            return false;
        }

        return meetingDetails.getTitle() != null && !meetingDetails.getTitle().isEmpty() &&
                meetingDetails.getStartTime() != null &&
                meetingDetails.getEndTime() != null;
                // need other security
    }

    @Override
    public void submit() {
        if (validate()) {
            //MeetingRepo.save(meetingDetails);
        } else {
            throw new IllegalArgumentException("Meeting details are not valid.");
        }
    }
}