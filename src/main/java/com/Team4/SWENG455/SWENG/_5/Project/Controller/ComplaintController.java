package com.Team4.SWENG455.SWENG._5.Project.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.SWENG455.SWENG._5.Project.Repository.ComplaintRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Complaint;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintRepo compRepo;

    @PostMapping("/createComplaint")
    public ResponseEntity<Void> createComplaint(
            @RequestParam("description") String description,
            HttpSession session) {

        // Get the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // Redirect to login page if no user is logged in
            return ResponseEntity.status(HttpStatus.FOUND)
                                 .location(URI.create("/login.html"))
                                 .build();
        }

        // Create a new Complaint object
        Complaint complaint = new Complaint();
        complaint.setDescription(description);
        complaint.setUserID(loggedInUser.getUserID()); // Set the userID to the logged-in user's ID
        complaint.setStatus("New"); // Set a default status for the complaint
        System.out.println(complaint.getDescription());
        // Save the complaint to the database
        compRepo.save(complaint);

        // Redirect to a confirmation page or back to the complaint page
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create("/complaint.html"))
                             .build();
    }

    // New endpoint to fetch the list of complaints
    @GetMapping("/api/complaints")
    public ResponseEntity<List<Complaint>> fetchComplaints() {
        List<Complaint> complaints = compRepo.findAll();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }
}
