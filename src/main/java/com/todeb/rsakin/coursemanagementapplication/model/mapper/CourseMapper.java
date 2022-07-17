package com.todeb.rsakin.coursemanagementapplication.model.mapper;

import com.todeb.rsakin.coursemanagementapplication.model.Course;
import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDetails(course.getDetails());
        courseDTO.setCountOfReview(course.getCountOfReview());
        courseDTO.setPoint(course.getPoint());
        courseDTO.setKeywords(course.getKeywords());
        courseDTO.setLangOptions(course.getLangOptions());
        courseDTO.setQuota(course.getQuota());
        courseDTO.setPrice(course.getPrice());
        return courseDTO;
    }

    public static Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDetails(courseDTO.getDetails());
        course.setCountOfReview(courseDTO.getCountOfReview());
        course.setPoint(courseDTO.getPoint());
        course.setKeywords(courseDTO.getKeywords());
        course.setLangOptions(courseDTO.getLangOptions());
        course.setQuota(courseDTO.getQuota());
        course.setPrice(courseDTO.getPrice());
        return course;
    }

}
