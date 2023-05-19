package com.example.srsfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainClasses.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterCoursesController {
    private static String studentID;
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = String.valueOf(studentID);
    }

    @FXML
    ComboBox cboxTerm;
    @FXML
    Button btnCancel;
    @FXML
    ListView ls;
    ObservableList<String> list = FXCollections.observableArrayList();
    ArrayList<Course> allCourses = new ArrayList<Course>();
    ArrayList<Course> registerableCourses = new ArrayList<Course>();
    allStudents allStudents = new allStudents();

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


        String[] csFaculties = {"John Smith", "Jane Doe"};
        Department csDepartment = new Department(1001, "Computer Science", csFaculties);
        Student johnDoe = new Student(1001, "John Doe", "1999-01-01", "123 Main St", "555-1234", 2022, "Fall", new ArrayList<Course>(), new ArrayList<Course>(), csDepartment, 3.4, 3.5);
        
        allStudents.add();

        filterCourses(mainClasses.allStudents.getStudentByID(studentID));
        ls.getItems().addAll(registerableCourses);
    }
    public void cancelOnclick (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setResizable(false);
        stage.setTitle("FCDS Home");
        stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
        stage.setScene(scene);
        stage.show();
        for(Course course: registerableCourses) {
            System.out.println(course.getName());
        }
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
        for(Course course: registerableCourses){
            for(Course Done: S1.getAllRegisteredCourses()){
                if(course == Done){
                    registerableCourses.remove(course);
                }
                for(Department department: course.getDepartments()){
                    if(department!=S1.getDepartment()){
                        registerableCourses.remove(course);
                    }
                }
            }
        }
    }
}