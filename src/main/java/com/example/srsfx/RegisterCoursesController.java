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
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainClasses.Course;
import mainClasses.Department;
import mainClasses.Instructor;
import mainClasses.Student;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterCoursesController {
    @FXML
    ComboBox cboxTerm;
    @FXML
    TableColumn tcCourseName;
    @FXML
    TableColumn tcCourseID;
    @FXML
    TableColumn tcDay;
    @FXML
    TableColumn tcPeriod;
    @FXML
    TableColumn tcClassroom;
    @FXML
    TableColumn tcInstructor;
    @FXML
    TableColumn tcCredits;
    @FXML
    TableColumn tcSeats;
    @FXML
    Button btnCancel;
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

        tcCourseName.setSortable(false);
        tcCourseName.setResizable(false);
        tcCourseID.setSortable(false);
        tcCourseID.setResizable(false);
        tcDay.setSortable(false);
        tcDay.setResizable(false);
        tcPeriod.setSortable(false);
        tcPeriod.setResizable(false);
        tcClassroom.setSortable(false);
        tcClassroom.setResizable(false);
        tcInstructor.setSortable(false);
        tcInstructor.setResizable(false);
        tcCredits.setSortable(false);
        tcCredits.setResizable(false);
        tcSeats.setSortable(false);
        tcSeats.setResizable(false);

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