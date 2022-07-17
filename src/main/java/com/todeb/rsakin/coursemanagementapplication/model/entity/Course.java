package com.todeb.rsakin.coursemanagementapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

// @Enumerated(EnumType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String details;
    private double price;
    private int quota;
    private int numberOfPeopleBought;
    private int countOfReview;
    private double point;

//    @ManyToOne
//    private Instructor instructor;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.MERGE)
    private List<Student> students;

}
