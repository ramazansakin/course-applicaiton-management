package com.todeb.rsakin.coursemanagementapplication.model.mapper;

import com.todeb.rsakin.coursemanagementapplication.model.entity.Course;
import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDetails(course.getDetails());
        courseDTO.setQuota(course.getQuota());
        courseDTO.setPrice(course.getPrice());
        return courseDTO;
    }

    public static Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDetails(courseDTO.getDetails());
        course.setQuota(courseDTO.getQuota());
        course.setPrice(courseDTO.getPrice());
        return course;
    }

}
