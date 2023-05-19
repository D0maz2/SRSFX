package com.example.srsfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
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

        filterCourses(mainClasses.Student.getStudentByID(studentID));
        ObservableList<Course> observableList = FXCollections.observableList(registerableCourses);
        ls.setItems(observableList);

        //Test if this works first
        ls.setCellFactory(new Callback<ListView<Course>, ListCell<Course>>() {
            @Override
            public ListCell<Course> call(ListView<Course> param) {
                return new ListCell<Course>() {
                    @Override
                    protected void updateItem(Course item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName() + " " + item.getCourseNumber() + " " + item.getDayOfTheWeek() + " " + item.getPeriods() + " " + item.getClassroom() + " " + item.getCredits() + " " + item.getClassroom().getCurrentCapacity());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        ls.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                mainClasses.Course selectedItem = (Course) ls.getSelectionModel().getSelectedItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Register " + selectedItem.getName() + "?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    System.out.println("Course Registered: " + selectedItem.getName());
                }
            }
        });
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