package com.todeb.rsakin.coursemanagementapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// @Enumerated(EnumType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;
    private String title;
    private String details;
    private double price;
    private int quota;
    private int numberOfPeopleBought;
    private int countOfReview;
    private double point;
    private List<String> keywords;
    private List<LangOptions> langOptions;
    private Instructor instructor;
    private List<Student> students;

    private static long idSequence = 1;

    public Course(String title, String details, double price, int quota, int numberOfPeopleBought, int countOfReview, double point, List<String> keywords, List<LangOptions> langOptions, Instructor instructor, List<Student> students) {
        this.id = ++idSequence;
        this.title = title;
        this.details = details;
        this.price = price;
        this.quota = quota;
        this.numberOfPeopleBought = numberOfPeopleBought;
        this.countOfReview = countOfReview;
        this.point = point;
        this.keywords = keywords;
        this.langOptions = langOptions;
        this.instructor = instructor;
        this.students = students;
    }
}
