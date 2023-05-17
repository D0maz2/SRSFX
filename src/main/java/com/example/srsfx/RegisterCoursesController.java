package com.example.srsfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import mainClasses.Course;
import mainClasses.Student;

import java.util.ArrayList;

public class RegisterCoursesController {
    @FXML
    ComboBox cboxTerm;
    ObservableList<String> list = FXCollections.observableArrayList();
    ArrayList<Course> allCourses = new ArrayList<Course>();
    ArrayList<Course> registerableCourses = new ArrayList<Course>();
    public void initialize(){
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
        list.add("Sixth");
        list.add("Seventh");
        list.add("Eighth");
        cboxTerm.setItems(list);
    }

    public void filterCourses(Student S1){
        for(Course course: allCourses){
            if(course.getPrerequisites()==null){
                registerableCourses.add(course);
            } else{
                    if(S1.getAllRegisteredCourses().contains(course.getPrerequisites())){
                        registerableCourses.add(course);
                }
            }
        }

    }
}