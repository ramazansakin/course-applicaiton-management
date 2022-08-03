package com.todeb.rsakin.coursemanagementapplication.service;

import com.todeb.rsakin.coursemanagementapplication.exception.EntityNotFoundException;
import com.todeb.rsakin.coursemanagementapplication.model.dto.CourseDTO;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Course;
import com.todeb.rsakin.coursemanagementapplication.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    private Course testCourse;

//    @BeforeAll
//    public void setup() {
//        // init
//      // testCourse = new Course(2L, "Math");
//
//    }

//    @BeforeEach
//    public void setup() {
//

//
//        Passenger expectedPassenger = new Passenger(1, "Passenger1", "Lastname1", "Male", 25, "05554443322", "passenger1@mail.com");
//
//        // stub - when
//        Mockito.when(passengerRepository.findById(1)).thenReturn(Optional.of(expectedPassenger));
//    }

    @Ignore
    @Test
    void getAllCourses() {
        // init step
        List<Course> expCourseList = getSampleTestCourses();

        // stub - when step
        Mockito.when(courseRepository.findAll()).thenReturn(expCourseList);

        // then - validate step
        List<Course> actualCourseList = courseService.getAllCourses();

        Assert.assertEquals(expCourseList.size(), actualCourseList.size());

        System.out.println("First: " + expCourseList);
        expCourseList = expCourseList.stream().sorted(getCourseComparator()).collect(Collectors.toList());
        actualCourseList = actualCourseList.stream().sorted(getCourseComparator()).collect(Collectors.toList());
        for (int i = 0; i < expCourseList.size(); i++) {
            Course currExpectedCourse = expCourseList.get(i);
            Course currActualCourse = actualCourseList.get(i);
            Assert.assertEquals(currExpectedCourse.getId(), currActualCourse.getId());
            Assert.assertEquals(currExpectedCourse.getTitle(), currActualCourse.getTitle());
            // ...
        }

        System.out.println("Second : " + expCourseList);

    }

    @Test
    void getById_successful() {
        // init step
        Course expectedCourse = getSampleTestCourses().get(1);
        Optional<Course> optExpectedCourse = Optional.of(expectedCourse);

        // stub - when step
        Mockito.when(courseRepository.findById(Mockito.any())).thenReturn(optExpectedCourse);

        // then - validate step
        Course actualCourse = courseService.getById(10L);

        Assert.assertEquals(actualCourse.getId(), expectedCourse.getId());
        Assert.assertEquals(actualCourse.getTitle(), expectedCourse.getTitle());
        // ...
    }

    @Test
    void getById_NOT_FOUND() {
        // stub - when step
        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.empty());

        // then - validate step
        assertThrows(EntityNotFoundException.class,
                () -> {
                    Course actCourse = courseService.getById(1L);
                }
        );

    }

    @Test
    void create() {
        // init step
        Course expected = getSampleTestCourses().get(0);
        expected.setId(null);
//        CourseDTO courseDTO = new CourseDTO();
//        courseDTO.setTitle(expected.getTitle());
        // ...

        // stub - when step
        Mockito.when(courseRepository.save(Mockito.any())).thenReturn(expected);

        // then - validate step
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle(expected.getTitle());

        Course actualCourse = courseService.create(courseDTO);

        // DTO mapping
//        Course actual = courseService.create(expectedDTO);

        Assert.assertEquals(expected.getTitle(), actualCourse.getTitle());
        Assert.assertEquals(expected.getDetails(), actualCourse.getDetails());
        Assert.assertEquals(expected.getQuota(), actualCourse.getQuota());
    }

    @Test
    void delete() {
        // init step
        Long courseId = 1L;
        Course course = getSampleTestCourses().get(0);

        // stub - when step
        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        doNothing().when(courseRepository).deleteById(courseId);

        // then - validate step
        courseService.delete(1L);

        verify(courseRepository, times(1)).deleteById(courseId);
    }

    @Test
    void update() {
        // init step

        // stub - when step

        // then - validate step
    }

    @Test
    void getAllStudentsByCourse() {
        // init step

        // stub - when step

        // then - validate step
    }

    private List<Course> getSampleTestCourses() {
        List<Course> sampleList = new ArrayList<>();
        Course course = new Course(1L, "Math", "Details 1", 45.9, 100, 0, 0, 0, null);
        Course course2 = new Course(2L, "Physics", "Details 2", 45.9, 100, 0, 0, 0, null);
        Course course3 = new Course(3L, "Chemistry", "Details 3", 45.9, 100, 0, 0, 0, null);
        sampleList.add(course2);
        sampleList.add(course);
        sampleList.add(course3);
        return sampleList;
    }

    private Comparator<Course> getCourseComparator() {
        return (o1, o2) -> {
            if (o1.getId() - o2.getId() < 0)
                return -1;
            if (o1.getId() - o2.getId() == 0)
                return 0;
            return 1;
        };
    }
}