package com.tandem.Tandem.Calendar;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tandem.Tandem.User.UserDetails.CustomUserDetails;
import com.tandem.Tandem.User.UserDetails.CustomUserDetailsService;
import com.tandem.Tandem.responses.Response;
import com.tandem.Tandem.responses.StatusResponse;

@Controller
public class CalendarController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/calendar")
    public ResponseEntity<Response> setName(Model model, Principal principal) {
        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        // model.addAttribute("firstname", userDetails.getFirstName());
        // ImportCalendar ic = new ImportCalendar();
        // try {
        // ic.parseCalendarFile("./src/main/resources/static/outlook.ics");
        // } catch (IOException | ParserException e) {
        // e.printStackTrace();
        // }
        Response resp = new StatusResponse();
        resp.setStatus(true);
        resp.setMessage(principal.getName());
        return new ResponseEntity<Response>(resp, HttpStatus.OK);
    }
}
