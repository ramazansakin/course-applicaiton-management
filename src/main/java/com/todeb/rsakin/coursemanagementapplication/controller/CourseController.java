package com.todeb.rsakin.coursemanagementapplication.controller;

import com.todeb.rsakin.coursemanagementapplication.model.Course;
import com.todeb.rsakin.coursemanagementapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/course/all")
    public ResponseEntity getAllCourses(){
        List<Course> allCourses = courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping("/api/course/2")
    public ResponseEntity getCourseById(){

    }


}
