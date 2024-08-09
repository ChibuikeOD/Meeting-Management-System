package com.Team4.SWENG455.SWENG._5.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.List;

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
    
    @GetMapping("/api/meetings")
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        List<Meeting> meetings = meetingRepository.findAll();
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }
    
    @GetMapping("/home")
    public ResponseEntity<Void> homePage(HttpSession session) {
        // Assuming your session is properly set up with the required attributes

        // Normally you'd add meetings to a model and return a view, but to demonstrate using ResponseEntity:
        List<Meeting> meetings = meetingRepository.findAll();

        // You would normally return a view like this, but instead, we'll redirect:
        // return new ModelAndView("home", "meetings", meetings);

        // Redirect to the home page with the meetings loaded
        URI homeUri = URI.create("/home.html");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(homeUri);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
    
    @PostMapping("/joinMeeting/{meetingId}")
    public ResponseEntity<Void> joinMeeting(@PathVariable("meetingId") String meetingId, HttpSession session) {
        // Get the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // Redirect to login page if no user is logged in
            URI loginUri = URI.create("/login.html");
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(loginUri);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }

        // Retrieve the meeting from the database
        Meeting meeting = meetingRepository.findById(meetingId).orElse(null);

        if (meeting != null) {
            // Add the logged-in user to the participants list
            meeting.addParticipant(loggedInUser);
            meetingRepository.save(meeting);
        }

        // Redirect back to the home page
        URI homeUri = URI.create("/home.html");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(homeUri);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
