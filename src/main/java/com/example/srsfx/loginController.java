package com.example.srsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
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
    Label welcomeid;
    public void switchToRegister(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("registerScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setResizable(false);
        stage.setTitle("SRS Register");
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
    public void btnLog(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String id = tfUsername.getText();
        String pass = Password.getText();

        if (passwordCheck(id,pass)){
            welcomeid.setText("Granted");
            welcomeid.setTextFill(Color.GREEN);
            welcomeid.setTextAlignment(CENTER);
            FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("Home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setResizable(false);
            stage.setTitle("Home");
            stage.getIcons().add(new Image(HomeController.class.getResourceAsStream("/thumbnail.jpg")));
            stage.setScene(scene);
            stage.show();
        }else {
            welcomeid.setText("Denied");
            welcomeid.setTextFill(Color.RED);
            welcomeid.setTextAlignment(CENTER);
        }
    }

}
