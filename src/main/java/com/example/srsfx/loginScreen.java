package com.example.srsfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mainClasses.Course;
import mainClasses.Student;

import java.io.IOException;

public class loginScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException{
        Student.loadStudents();
        Course.loadCourses();
        FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setResizable(false);
        stage.setTitle("FCDS Login");
        stage.getIcons().add(new Image(loginScreen.class.getResourceAsStream("/thumbnail.jpg")));
        stage.setScene(scene);
        stage.show();           //Must be at the end of the start function
    }

    public static void main(String[] args) throws IOException {
        launch();

    }
}