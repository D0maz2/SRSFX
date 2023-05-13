package com.example.srsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

public void student(){

rdbtnDS.setToggleGroup(Dpt);
rdbtnCS.setToggleGroup(Dpt);
rdbtnIS.setToggleGroup(Dpt);
rdbtnBI.setToggleGroup(Dpt);
rdbtnMedia.setToggleGroup(Dpt);
}
public void instructor(){

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
