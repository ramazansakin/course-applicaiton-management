package com.todeb.rsakin.coursemanagementapplication.model.dto;

import com.todeb.rsakin.coursemanagementapplication.model.LangOptions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseDTO {

    private String title;
    private String details;
    private double price;
    private int quota;
    private int numberOfPeopleBought;
    private int countOfReview;
    private double point;
    private List<String> keywords;
    private List<LangOptions> langOptions;

}
