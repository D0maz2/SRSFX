package com.example.srsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.LightBase;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HomeController {
    private static String idlogin;

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        HomeController.student = student;
    }

    private static boolean student;
    @FXML
    ImageView profileid;
    @FXML
    Label lbName;
    @FXML
    Label lbDep;
    @FXML
    Label lbDOB;
    @FXML
    Label lbPhone;
    @FXML
    Label lbCGPA;
    @FXML
    Label lbID;
    @FXML
    Label lbEY;
    @FXML
    Label lbES;
    @FXML
    Label lbAddress;

    public String getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(String idlogin) {
        this.idlogin = idlogin;
    }

    public void initialize() throws IOException {
            dataload(idlogin);
    }
        public void cancelOnclick (ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setResizable(false);
            stage.setTitle("FCDS Login");
            stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
            stage.setScene(scene);
            stage.show();
        }
        public void dataload (String id) throws IOException {
            ArrayList<String> data = readData(id);
            lbName.setText(data.get(0));
            lbID.setText(data.get(1));
            lbDOB.setText(data.get(2));
            lbPhone.setText(data.get(3));
            lbAddress.setText(data.get(4));
            lbDep.setText(data.get(5));
            lbCGPA.setText(data.get(7));
            lbEY.setText(data.get(8));
            lbES.setText(data.get(9));
        }

        public ArrayList<String> readData (String id) throws IOException {
            ArrayList<String> data = new ArrayList<>();
            Workbook workbook;
            workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
            Sheet sheet = workbook.getSheet(id);
            Row row = sheet.getRow(1);
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                data.add(row.getCell(i).toString());
            }
            return data;
        }
    }

