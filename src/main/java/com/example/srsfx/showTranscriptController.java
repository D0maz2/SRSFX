package com.example.srsfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainClasses.Course;
import mainClasses.Student;

import java.io.IOException;

public class showTranscriptController {
    @FXML
    TableView<Course> tvTable;
    @FXML
    TableColumn tcCourseName;
    @FXML
    TableColumn tcCourseID;
    @FXML
    TableColumn tcCredits;
    @FXML
    TableColumn tcGrade;


    private static String studentID;

    public static String getStudentID() {
        return studentID;
    }
    public static void setStudentID(String studentID) {
        showTranscriptController.studentID = studentID;
    }
    @FXML
    public void initialize() {
        Student student = Student.getStudentByID(studentID);
        ObservableList<Course> data = FXCollections.observableArrayList(student.getAllRegisteredCourses());

        tvTable.setItems(data);
        tcCourseName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcCourseID.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
        tcCredits.setCellValueFactory(new PropertyValueFactory<>("credits"));
        tcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
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
}
