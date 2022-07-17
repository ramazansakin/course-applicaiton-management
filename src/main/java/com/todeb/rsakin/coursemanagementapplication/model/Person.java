package com.todeb.rsakin.coursemanagementapplication.model;

import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    private String name;
    private String surname;
    private String about;
    private String email;
}
