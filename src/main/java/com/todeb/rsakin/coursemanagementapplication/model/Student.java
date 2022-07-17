package com.todeb.rsakin.coursemanagementapplication.model;

import java.util.List;

// @MappedSuperClass
public class Student extends Person {

    private List<Course> courses;
    private List<Certificate> certificates;

}
