package com.todeb.rsakin.coursemanagementapplication.model;

import java.util.List;

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

    public Course(String title, String details, double price, int quota,
                  int numberOfPeopleBought, int countOfReview,
                  double point, List<String> keywords, List<LangOptions> langOptions,
                  Instructor instructor, List<Student> students) {
        this.id = idSequence++;
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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getNumberOfPeopleBought() {
        return numberOfPeopleBought;
    }

    public void setNumberOfPeopleBought(int numberOfPeopleBought) {
        this.numberOfPeopleBought = numberOfPeopleBought;
    }

    public int getCountOfReview() {
        return countOfReview;
    }

    public void setCountOfReview(int countOfReview) {
        this.countOfReview = countOfReview;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<LangOptions> getLangOptions() {
        return langOptions;
    }

    public void setLangOptions(List<LangOptions> langOptions) {
        this.langOptions = langOptions;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
