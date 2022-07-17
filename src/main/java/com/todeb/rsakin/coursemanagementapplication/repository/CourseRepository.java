package com.todeb.rsakin.coursemanagementapplication.repository;

import com.todeb.rsakin.coursemanagementapplication.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // JPQL
    Optional<Course> findCourseByTitle(String title);

    List<Course> getAllByPriceIsLessThan(Double price);

    List<Course> getAllByDetailsContainingIgnoreCase(String details);

    List<Optional<Course>> findAllByTitleAndPrice(String title, Double price);

    // Native SQL
    @Query("SELECT c FROM Course c WHERE c.title = :title AND c.price = :price")
    List<Course> getAllByTitleAndPriceNative(String title, Double price);

//    private List<Course> courseList = new ArrayList<>();
//    @PostConstruct
//    private void init() {
//
//    }

//    {
//        List<String> sampleJavaKeywords = new ArrayList<>();
//        sampleJavaKeywords.addAll(Arrays.asList("Java", "Spring", "Boot", "AOP"));
//        List<LangOptions> sampleJavaCourseLangOptions = new ArrayList<>();
//        sampleJavaCourseLangOptions.add(LangOptions.TURKISH);
//        sampleJavaCourseLangOptions.add(LangOptions.ENGLISH);
//
//        courseList.add(new Course("Java Programming", "Java EE Web Development / Java Core ",
//                49.99, 1000, 0, 0, 0, sampleJavaKeywords,
//                sampleJavaCourseLangOptions,
//                null, null));
//
//        List<String> sampleJavaKeywords2 = new ArrayList<>();
//        sampleJavaKeywords2.addAll(Arrays.asList("C++", "OOP", "Class", "Encapsulation"));
//        List<LangOptions> sampleJavaCourseLangOptions2 = new ArrayList<>();
//        sampleJavaCourseLangOptions2.add(LangOptions.SPANISH);
//        sampleJavaCourseLangOptions2.add(LangOptions.GERMAN);
//        sampleJavaCourseLangOptions2.add(LangOptions.ENGLISH);
//
//        courseList.add(new Course("Object Oriented Programming",
//                "Object Oriented Paradigm fundamentals with C++ / Inheritance / Polimorhism",
//                149.99, 2000, 0, 0, 0, sampleJavaKeywords2,
//                sampleJavaCourseLangOptions2,
//                null, null));
//    }

//    public List<Course> findAll() {
//        return courseList;
//    }


//    public Optional<Course> getById(Long id) {
//
//        Optional<Course> courseOpt = courseList.stream()
//                .filter(course -> course.getId().equals(id)).findFirst();
//
//        return courseOpt;
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
//    }
//
//    public Course create(Course course) {
//        boolean addStatus = courseList.add(course);
//        if (!addStatus) {
//            return null;
//        }
//        return course;
//    }

}
