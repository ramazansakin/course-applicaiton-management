package com.todeb.rsakin.coursemanagementapplication.repository;

import com.todeb.rsakin.coursemanagementapplication.model.Course;
import com.todeb.rsakin.coursemanagementapplication.model.LangOptions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CourseRepository {

    private List<Course> courseList = new ArrayList<>();

//    @PostConstruct
//    private void init() {
//
//    }

    {
        List<String> sampleJavaKeywords = new ArrayList<>();
        sampleJavaKeywords.addAll(Arrays.asList("Java", "Spring", "Boot", "AOP"));
        List<LangOptions> sampleJavaCourseLangOptions = new ArrayList<>();
        sampleJavaCourseLangOptions.add(LangOptions.TURKISH);
        sampleJavaCourseLangOptions.add(LangOptions.ENGLISH);

        courseList.add(new Course("Java Programming", "Java EE Web Development / Java Core ",
                49.99, 1000, 0, 0, 0, sampleJavaKeywords,
                sampleJavaCourseLangOptions,
                null, null));

        List<String> sampleJavaKeywords2 = new ArrayList<>();
        sampleJavaKeywords2.addAll(Arrays.asList("C++", "OOP", "Class", "Encapsulation"));
        List<LangOptions> sampleJavaCourseLangOptions2 = new ArrayList<>();
        sampleJavaCourseLangOptions2.add(LangOptions.SPANISH);
        sampleJavaCourseLangOptions2.add(LangOptions.GERMAN);
        sampleJavaCourseLangOptions2.add(LangOptions.ENGLISH);

        courseList.add(new Course("Object Oriented Programming",
                "Object Oriented Paradigm fundamentals with C++ / Inheritance / Polimorhism",
                149.99, 2000, 0, 0, 0, sampleJavaKeywords2,
                sampleJavaCourseLangOptions2,
                null, null));
    }

    public List<Course> findAll() {
        return courseList;
    }

    public Course getById(Long id) {

        Optional<Course> courseOpt = courseList.stream()
                .filter(course -> course.getId().equals(id)).findFirst();

        return courseOpt.orElse(null);
//
//        courseList.forEach(course -> {
//            Long id1 = course.getId();
//            System.out.println(id);
//            // ...
//        });


//        for (Course course : courseList) {
//            if (course.getId().equals(id))
//                return course;
//        }
    }

}
