package com.example.srsfx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.collections.FXCollections;

import java.io.IOException;

public class registerController {
@FXML
    RadioButton rdbtnStudent;
@FXML
    RadioButton rdbtnInstructor;
@FXML
    Button btnCancel;
@FXML
    RadioButton rdbtnDS;
@FXML
    RadioButton rdbtnCS;
@FXML
    RadioButton rdbtnIS;
@FXML
    RadioButton rdbtnBI;
@FXML
    RadioButton rdbtnMedia;
@FXML
    ToggleGroup Dpt;
@FXML
    Label EnrollmentYear;
@FXML
    TextField tfEnrollmentYear;
@FXML
    ComboBox cboxSemester;
@FXML
    Label EnrollmentSemester;

ObservableList<String> list = FXCollections.observableArrayList();
public void initialize(){
    list.add("Fall");
    list.add("Spring");
    cboxSemester.setItems(list);

    tfEnrollmentYear.setVisible(false);
    EnrollmentYear.setVisible(false);

    EnrollmentSemester.setVisible(false);
    cboxSemester.setVisible(false);
}

public void student(){

tfEnrollmentYear.setVisible(true);
EnrollmentYear.setVisible(true);

EnrollmentSemester.setVisible(true);
cboxSemester.setVisible(true);

rdbtnDS.setToggleGroup(Dpt);
rdbtnCS.setToggleGroup(Dpt);
rdbtnIS.setToggleGroup(Dpt);
rdbtnBI.setToggleGroup(Dpt);
rdbtnMedia.setToggleGroup(Dpt);
}
public void instructor(){

tfEnrollmentYear.setVisible(false);
EnrollmentYear.setVisible(false);

EnrollmentSemester.setVisible(false);
cboxSemester.setVisible(false);

rdbtnDS.setToggleGroup(null);
rdbtnCS.setToggleGroup(null);
rdbtnIS.setToggleGroup(null);
rdbtnBI.setToggleGroup(null);
rdbtnMedia.setToggleGroup(null);
}
public void cancelOnclick(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load(), 800, 450);
    stage.setResizable(false);
    stage.setTitle("SRS Login");
    stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
    stage.setScene(scene);
    stage.show();
}
}
