package com.todeb.rsakin.coursemanagementapplication.service;

import com.todeb.rsakin.coursemanagementapplication.model.Course;
import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;
import com.todeb.rsakin.coursemanagementapplication.model.mapper.CourseMapper;
import com.todeb.rsakin.coursemanagementapplication.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    // 3 ways of Dependency Injection
    // 1 - Field Injection
    @Autowired
    private CourseRepository courseRepository;

    // 2 - Constructor Injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // 3 - Setter Injection
//    public void setCourseRepository(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    public List<Course> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }

    public Course getById(Long id) {
        Optional<Course> byId = courseRepository.getById(id);
        return byId.orElseThrow(() -> new RuntimeException("Course not found!"));
    }

    public Course create(CourseDTO courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        return courseRepository.create(course);
    }


}
