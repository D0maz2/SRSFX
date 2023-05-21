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
import java.util.Iterator;
import java.util.List;

public class RegisterCoursesController {
    private static String studentRegID;
    public String getStudentID() {
        return studentRegID;
    }
    public static void setStudentID(String studentID) {
        RegisterCoursesController.studentRegID=studentID;
    }
    private static Student S;
    @FXML
    RadioButton rdbtnFirst;
    @FXML
    RadioButton rdbtnSecond;
    @FXML
    Button btnCancel;
    @FXML
    ListView ls;
    ObservableList<String> list = FXCollections.observableArrayList();
    public void initialize(){
        Student student = Student.getStudentByID(studentRegID);

        ArrayList<Course> courses = Course.getCourses();
        ObservableList<Course> observableList = FXCollections.observableList(courses);
        ls.setItems(observableList);



            if(rdbtnFirst.isSelected()){
                for(Course course : courses){
                if(course.getTerm()!=1){
                    courses.remove(course);
                }
            }
            }
        if(rdbtnSecond.isSelected()){
            for(Course course : courses){
                if(course.getTerm()!=2){
                    courses.remove(course);
                }
            }
        }
        //Test if this works first
        ls.setCellFactory(new Callback<ListView<Course>, ListCell<Course>>() {
            @Override
            public ListCell<Course> call(ListView<Course> param) {
                return new ListCell<Course>() {
                    @Override
                    protected void updateItem(Course item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName() + " " + item.getCourseNumber() + " " + item.getDayOfTheWeek() + " " + item.getPeriods() + " " + item.getClassroom().getLocation() + " " + item.getCredits() + " " + item.getClassroom().getCurrentCapacity());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        ls.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Course selectedItem = (Course) ls.getSelectionModel().getSelectedItem();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Register " + selectedItem.getName() + "?", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.YES) {
                        System.out.println("Course Registered: " + selectedItem.getName());
                        student.getAllRegisteredCourses().add(selectedItem);
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
    }

//    private ArrayList<Course> filterCourses(Student s, ArrayList<Course> registerableCourses) {
//        System.out.println("I started running in the woods.");
//        registerableCourses.clear();
//        Iterator<Course> iterator = Course.getCourses().iterator();
//        while (iterator.hasNext()) {
//            Course course = iterator.next();
//            boolean isDepartmentMatched = false;
//            boolean hasNoPrerequisites = false;
//            boolean arePrerequisitesMet = false;
//            for(Department department: course.getDepartments()) {
//                if (s.getDepartment() == null || department.equals(s.getDepartment())) {
//                    isDepartmentMatched = true;
//                    break;
//                }
//            }
//            if(course.getPrerequisites()==null){
//                hasNoPrerequisites = true;
//            }
//            if(s.getAllRegisteredCourses().contains(course.getPrerequisites())){
//                arePrerequisitesMet = true;
//            }
//            if (isDepartmentMatched && (hasNoPrerequisites || arePrerequisitesMet)) {
//                registerableCourses.add(course);
//            }
//        }
//
//        for (Course course:registerableCourses
//             ) {
//            System.out.println(course);
//
//        }
//        return registerableCourses;
//    }
}