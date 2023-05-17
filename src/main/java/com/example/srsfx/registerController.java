package com.example.srsfx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import mainClasses.Department;
import mainClasses.Instructor;
import mainClasses.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

public class registerController {
@FXML
    RadioButton rdbtnStudent;
@FXML
    RadioButton rdbtnInstructor;
@FXML
    Button btnCancel;
@FXML
Button btnRegister;
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

@FXML
TextField stuName;
@FXML
TextField stuId;
@FXML
TextField stuNumber;
@FXML
DatePicker stuDate;
@FXML
TextField stuAddress;
@FXML
PasswordField passid;
@FXML
PasswordField confpassid;
@FXML
Label passerror;



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
public static Department DepsSTUDENT(String name){
    String[] f1 = {"computers and data science","science"};
    Department d1 = new Department(1000,"Data Science",f1);
    Department d2 = new Department(1001,"Cyber Security",f1);
    Department d3 = new Department(1002,"Intelligent Systems",f1);
    Department d4 = new Department(1003,"Business Intelligence",f1);
    Department d5 = new Department(1004,"Media",f1);
    Department[] da = {d1,d2,d3,d4,d5};
    Department dep = null;
    for (int i =0;i< da.length;i++){
        if(Objects.equals(da[i].getName(), name)){
            dep = da[i];
            System.out.println(dep);
            break;
        }
    }
    return dep;
}
public boolean passwordSave(String password,String confPassword) throws IOException, NoSuchAlgorithmException {
    Workbook workbook = new HSSFWorkbook(new FileInputStream("password.xls"));
    Sheet sheet = workbook.getSheet("password");
    int lastRowindex = sheet.getLastRowNum()+1;
    boolean done = false;
    if (Objects.equals(password, confPassword)){
        sheet.createRow(lastRowindex).createCell(0).setCellValue(stuId.getText());
        sheet.getRow(lastRowindex).createCell(1).setCellValue(hashPassword(password));
        FileOutputStream fos = new FileOutputStream("password.xls");
        workbook.write(fos);
        fos.close();
        done = true;

    }else {
        passerror.setText("Password is not the same !!");
        passerror.setTextFill(Color.RED);
    }
    return done;
}
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        String hashedPassword = sb.toString();

        return hashedPassword;
    }
public void Registerclick(ActionEvent event) throws IOException, NoSuchAlgorithmException {
    String[] f1 = {"computers and data science","science"};
    if (rdbtnStudent.isSelected()) {
        RadioButton dep = (RadioButton) Dpt.getSelectedToggle();
        Student s1 = new Student(Integer.parseInt(stuId.getText()), stuName.getText(), stuDate.getValue().toString(), stuAddress.getText(), stuNumber.getText(), Integer.parseInt(tfEnrollmentYear.getText()), cboxSemester.getValue().toString(), null, null, DepsSTUDENT(dep.getText()), 0, 0);
        if (passwordSave(passid.getText(), confpassid.getText())) {
            s1.saveData();
            FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setResizable(false);
            stage.setTitle("FCDS Login");
            stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
            stage.setScene(scene);
            stage.show();
        }
    }else if (rdbtnInstructor.isSelected()) {
        ArrayList<Department> deps = new ArrayList<>();
        if (rdbtnBI.isSelected()) {
            deps.add(new Department(1000,"Business Intelligence",f1));
        }
        if (rdbtnCS.isSelected()) {
            deps.add(new Department(1001,"Cyber Security",f1));
        }
        if (rdbtnDS.isSelected()) {
            deps.add(new Department(1002,"Data Science",f1));
        }
        if (rdbtnIS.isSelected()) {
            deps.add(new Department(1003,"Intelligent Systems",f1));
        }
        if (rdbtnMedia.isSelected()) {
            deps.add(new Department(1004,"Media",f1));
        }
        Instructor i1 = new Instructor(Integer.parseInt(stuId.getText()), stuName.getText(), stuDate.getValue().toString(), stuAddress.getText(), stuNumber.getText(), deps);
        if (passwordSave(passid.getText(), confpassid.getText())) {
            i1.saveData();
            FXMLLoader fxmlLoader = new FXMLLoader(loginScreen.class.getResource("loginScreen.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 450);
            stage.setResizable(false);
            stage.setTitle("FCDS Login");
            stage.getIcons().add(new Image(registerController.class.getResourceAsStream("/thumbnail.jpg")));
            stage.setScene(scene);
            stage.show();
        }
    }
}
}
