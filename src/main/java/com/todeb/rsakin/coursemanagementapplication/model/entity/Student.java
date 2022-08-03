package com.todeb.rsakin.coursemanagementapplication.model.entity;

import com.todeb.rsakin.coursemanagementapplication.model.Person;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {

    @Id
    private Long id;

    // Commented Up
    // There is no repo, so it causes an error on project start-up!
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(
//            name = "students_courses",
//            joinColumns = {
//                    @JoinColumn(name = "student_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "course_id")
//            }
//    )
//    private List<Course> courses;

    // private List<Certificate> certificates;

}
