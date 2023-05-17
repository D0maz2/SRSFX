package com.example.srsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.io.IOException;
import java.util.ArrayList;

public class InstructorHomeController {
    private static String idlogininstructor;

    public  String getIdlogininstructor() {
        return idlogininstructor;
    }

    public  void setIdlogininstructor(String idlogininstructor) {
        InstructorHomeController.idlogininstructor = idlogininstructor;
    }

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
    Label lbID;
    @FXML
    Label lbAddress;

    public void initialize() throws IOException {
        dataload(idlogininstructor);
    }

    public void cancelOnclick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        stage.setResizable(false);
        stage.setTitle("FCDS Login");
        stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
        stage.setScene(scene);
        stage.show();
    }
    public String loadDeps (String id) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        Sheet sheet = workbook.getSheet(id);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            //data.add(sheet.getRow(i).getCell(5).toString());
            sb.append(sheet.getRow(i).getCell(5).toString()+"\n");
        }
        return sb.toString();
    }
    public void dataload(String id) throws IOException {
        ArrayList<String> data = readData(id);
        lbName.setText(data.get(0));
        lbID.setText(data.get(1));
        lbDOB.setText(data.get(2));
        lbPhone.setText(data.get(3));
        lbAddress.setText(data.get(4));
        lbDep.setText(loadDeps(id));
    }

    public ArrayList<String> readData (String id) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        Workbook workbook;
        workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        Sheet sheet = workbook.getSheet(id);
        Row row = sheet.getRow(1);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            data.add(row.getCell(i).toString());
        }
        return data;
    }
}
