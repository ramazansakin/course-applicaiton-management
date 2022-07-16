package com.todeb.rsakin.coursemanagementapplication.controller;

import com.todeb.rsakin.coursemanagementapplication.model.ResponseModel;
import com.todeb.rsakin.coursemanagementapplication.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    // http://localhost:8080/URI
    @GetMapping("/welcome")
    public ResponseEntity welcomeMessageApi() {
        String welcomeMsg = "Welcome to Course Management Application";
        ResponseModel responseModel = new ResponseModel();
        responseModel.setWelcomeMessage(welcomeMsg);
        return ResponseEntity.status(200).body(responseModel);
    }


}
