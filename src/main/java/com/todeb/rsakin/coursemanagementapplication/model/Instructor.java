package com.todeb.rsakin.coursemanagementapplication.model;

import lombok.Data;

import java.util.List;

@Data
public class Instructor extends Person{

    private List<Course> courses;

}
