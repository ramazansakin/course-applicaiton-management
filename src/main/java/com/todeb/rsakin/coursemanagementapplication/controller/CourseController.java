package com.todeb.rsakin.coursemanagementapplication.controller;

import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Course;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Student;
import com.todeb.rsakin.coursemanagementapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity getAllCourses() {
        List<Course> allCourses = courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable("id") Long id) {
        Course byId = courseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewCourse(@RequestBody CourseDTO course) {
        Course respCourse = courseService.create(course);
        if (respCourse == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Course could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respCourse);
    }

    // CQRS Pattern - Command Query Request Segregation
    // Command ve Query leri ayır
    // Command -> Create, Update, Delete > Transaction
    // Query -> Select / Read -> No Transaction

    //    synchronized (resource){
//
//    }
    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestParam(name = "id") Long id) {
        courseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Course deleted successfully");
    }

    @PutMapping("/{title}")
    public ResponseEntity updateCourse(
            @PathVariable String title,
            @RequestBody CourseDTO course) {
        Course update = courseService.update(title, course);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Course could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @GetMapping("/{course_id}/students")
    public ResponseEntity getAllStudentsByCourse(@PathVariable("course_id") Long course_id) {
        List<Student> allStudentsByCourse = courseService.getAllStudentsByCourse(course_id);
        return ResponseEntity.ok().body(allStudentsByCourse);
    }


}
