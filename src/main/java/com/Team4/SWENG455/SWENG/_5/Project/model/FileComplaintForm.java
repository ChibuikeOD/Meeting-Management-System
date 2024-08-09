package com.Team4.SWENG455.SWENG._5.Project.model;

import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;

public class FileComplaintForm extends GenericForm {
    private Complaint complaintDetails;

    public Complaint getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(Complaint complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    @Override
    public boolean validate() {
        if (complaintDetails == null) {
            return false;
        }

        String description = complaintDetails.getDescription();
        String status = complaintDetails.getStatus();


        return description != null && !description.isEmpty() &&
                status != null && !status.isEmpty() &&
                (status.equalsIgnoreCase("open") || status.equalsIgnoreCase("closed"));
    }

    public void submit() {
        if (validate()) {

            //ComplaintRepo.save(complaintDetails);

        } else {
            throw new IllegalArgumentException("Complaint details are not valid.");
        }
    }
}