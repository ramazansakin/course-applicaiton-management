package com.todeb.rsakin.coursemanagementapplication.service;

import com.todeb.rsakin.coursemanagementapplication.exception.EntityNotFoundException;
import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Course;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Student;
import com.todeb.rsakin.coursemanagementapplication.model.mapper.CourseMapper;
import com.todeb.rsakin.coursemanagementapplication.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    // 3 ways of Dependency Injection
    // 1 - Field Injection
    // @Autowired
    private final CourseRepository courseRepository;

//    @Autowired
//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    // 2 - Constructor Injection
//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    // 3 - Setter Injection
//    public void setCourseRepository(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    public List<Course> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }

    public Course getById(Long id) {
        Optional<Course> byId = courseRepository.findById(id);
        return byId.orElseThrow(() -> {
            log.error("Course not found by id : " + id);
            return new EntityNotFoundException("Course", "id : " + id);
        });
    }

    public Course create(CourseDTO courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        getById(id);
        courseRepository.deleteById(id);
//        getBy vs findBy
//        Course byId = courseRepository.getById(id);
//        Optional<Course> byId1 = courseRepository.findById(id);
    }

    public Course update(String title, CourseDTO course) {
        Optional<Course> courseByTitle = courseRepository.findCourseByTitle(title);
        if (!courseByTitle.isPresent())
            throw new EntityNotFoundException("Course", "title : " + title);
//        Course course1 = new Course();
//        course1.setId(courseByTitle.get().getId());
        Course updatedCourse = courseByTitle.get();
        log.debug("Course title : " + course.getTitle());
        if (!StringUtils.isEmpty(course.getTitle())) {
            updatedCourse.setTitle(course.getTitle());
        }
        if (!StringUtils.isEmpty(course.getDetails())) {
            updatedCourse.setDetails(course.getDetails());
        }

        return courseRepository.save(updatedCourse);
    }

    public List<Student> getAllStudentsByCourse(Long courseId) {
        Course byId = getById(courseId);
        return byId.getStudents();
    }

//    public static void main(String[] args) {
//        Optional<String> test = Optional.of("");
//
//        String dEfault = test.orElse("DEfault");
//        System.out.println("Result: " + dEfault);
//    }

}
