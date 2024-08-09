package com.Team4.SWENG455.SWENG._5.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.Team4.SWENG455.SWENG._5.Project.Repository.MeetingRepo;
import com.Team4.SWENG455.SWENG._5.Project.Repository.UserRepo;
import com.Team4.SWENG455.SWENG._5.Project.model.Meeting;
import com.Team4.SWENG455.SWENG._5.Project.model.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@Controller
public class MeetingController {

    @Autowired
    private MeetingRepo meetingRepository;

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/createMeeting")
    public ResponseEntity<Void> createMeeting(@RequestParam("title") String title,
                                              @RequestParam("description") String description,
                                              @RequestParam("startTime") String startTime,
                                              HttpSession session) {

        // Retrieve the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // If no user is logged in, redirect to the login page
            URI loginUri = URI.create("/login.html");
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(loginUri);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }

        // Create a new Meeting object
        Meeting meeting = new Meeting();
        meeting.setTitle(title);
        meeting.setDescription(description);
        meeting.setStartTime(startTime);
        System.out.println(meeting.getStartTime());

        // Add the logged-in user as a participant
        meeting.addParticipant(loggedInUser);
        System.out.println(loggedInUser.getName());
        // Save the meeting to the database
        meetingRepository.save(meeting);

        // Prepare the redirect URL (e.g., to the home page)
        URI redirectUri = URI.create("/home.html");

        // Return a ResponseEntity with a FOUND status and the Location header for redirection
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(redirectUri);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
