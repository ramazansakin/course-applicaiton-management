package com.todeb.rsakin.coursemanagementapplication.model.entity;

import com.todeb.rsakin.coursemanagementapplication.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class Instructor extends Person {

    private List<Course> courses;

}
