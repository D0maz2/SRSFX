package com.example.srsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static javafx.scene.text.TextAlignment.CENTER;

public class loginController {
//    @FXML    is used when some component is given an fx:id and is declared as a private attribute/method and then we need the @FXML 2o inject the component correctly
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField tfUsername;
    @FXML
    PasswordField Password;
    @FXML
    RadioButton instructorid;
    @FXML
    RadioButton studentid;
    @FXML
    ToggleGroup logdep;

    @FXML
    Label welcomeid;
    public void switchToRegister(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("registerScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setResizable(false);
        stage.setTitle("FCDS Register");
        stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
        stage.setScene(scene);
        stage.show();
    }
    public static boolean passwordCheck(String id,String password) throws IOException, NoSuchAlgorithmException {
        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = new HSSFWorkbook(new FileInputStream("password.xls"));
        Sheet sheet = workbook.getSheet("password");
        boolean accept = false;
        for (int i = 0;i < sheet.getPhysicalNumberOfRows();i++){
            Row row = sheet.getRow(i);
            String name = dataFormatter.formatCellValue(row.getCell(0));
            String pass = dataFormatter.formatCellValue(row.getCell(1));
            if (Objects.equals(name, id) && Objects.equals(registerController.hashPassword(password), pass)){
                accept = true;
                break;
            }
        }
        return accept;
    }
    public boolean idCheck(String id,boolean student) throws IOException {
        Workbook workbook;
        if(student) {
             workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
        }else {
             workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        }
        boolean done = false;
        for (int i = 0;i<workbook.getNumberOfSheets();i++){
            String sheet = workbook.getSheetName(i);
            if(Objects.equals(sheet, id)){
                done = true;
            }
        }
       return done;
    }
    public void btnLog(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String id = tfUsername.getText();
        String pass = Password.getText();
        if(instructorid.isSelected()) {
            if (passwordCheck(id, pass) && idCheck(id,false)) {
                welcomeid.setText("Granted");
                welcomeid.setTextFill(Color.GREEN);
                welcomeid.setTextAlignment(CENTER);
                FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("Home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 800, 450);
                stage.setResizable(false);
                stage.setTitle("Home");
                stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("/thumbnail.jpg")));
                stage.setScene(scene);
                stage.show();
            } else {
                welcomeid.setText("Denied");
                welcomeid.setTextFill(Color.RED);
                welcomeid.setTextAlignment(CENTER);
            }
        }else if(studentid.isSelected()){
            if (passwordCheck(id, pass) && idCheck(id,true)) {
                FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("Home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 800, 450);
                stage.setResizable(false);
                stage.setTitle("Home");
                stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("/thumbnail.jpg")));
                stage.setScene(scene);
                stage.show();
            } else {
                welcomeid.setText("Denied");
                welcomeid.setTextFill(Color.RED);
                welcomeid.setTextAlignment(CENTER);
            }
        }
        else {
            welcomeid.setText("Profession ?");
            welcomeid.setTextFill(Color.RED);
            welcomeid.setTextAlignment(CENTER);
        }
    }

}