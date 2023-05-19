package mainClasses;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Instructor extends Person{
    private ArrayList<Department> departments;
     public static ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    private static ArrayList<Instructor> instructors = new ArrayList<>();


    public Instructor(int ID, String name, String dateOfBirth, String address, String telephoneNumber, ArrayList<Department> departments)
    {
        super(ID, name, dateOfBirth, address, telephoneNumber);
        this.departments = departments;
        instructors.add(this);
    }
    public ArrayList<Department> getDepartments()
    {
        return departments;
    }
    public void setDepartments(ArrayList<Department> departments)
    {
        this.departments = departments;
    }


    public void loadDepartments() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        Sheet sheet = workbook.getSheet(""+getID());
        System.out.println(getDepartments().size());
        Row row;
        for (int i = 0;i<getDepartments().size();i++){
            if(sheet.getRow(i+1) == null) {
                row = sheet.createRow(i+1);
            }else {
                row = sheet.getRow(i+1);
            }
            row.createCell(5).setCellValue(getDepartments().get(i).getName());
            row.createCell(6).setCellValue(getDepartments().get(i).getID());
            int j =0;
//            for(int x = 0;x< getDepartments().get(i).getFaculties().length;x++) {
//                if(sheet.getRow(i+1+j) == null) {
//                    sheet.createRow(i + 1 + j).createCell(7).setCellValue(getDepartments().get(i).getFaculties()[x]);
//                }
//                else {
//                    sheet.getRow(i + 1 + j).createCell(7).setCellValue(getDepartments().get(i).getFaculties()[x]);
//                }
//                j++;
//            }
            for (int z = 0; z < row.getLastCellNum(); z++) {
                sheet.autoSizeColumn(z);
            }
        }
        FileOutputStream fos = new FileOutputStream("Database_instructors.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("Data saved: " + "Database_instructors.xls");
    }

    public void saveData() throws IOException {
        String[] header = {"Name","ID","Date of Birth","Telephone Number","Address","Department","ID"};
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        Sheet sheet;
        if(workbook.getSheet(""+getID()) != null) {
            sheet = workbook.getSheet(""+getID());
        }
        else{
            sheet = workbook.createSheet(""+getID());
        }
        Row data_row = sheet.createRow(0);
        for(int j = 0;j< header.length;j++) {
            data_row.createCell(j).setCellValue(header[j]);
        }
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue(getName());
        row.createCell(1).setCellValue(getID());
        row.createCell(2).setCellValue(getDateOfBirth());
        row.createCell(3).setCellValue(getTelephoneNumber());
        row.createCell(4).setCellValue(getAddress());
        for (int z = 0; z < row.getLastCellNum(); z++) {
            sheet.autoSizeColumn(z);
        }
        FileOutputStream fos = new FileOutputStream("Database_instructors.xls");
        workbook.write(fos);
        fos.close();
        loadDepartments();
    }

    @Override
    public String toString() {
        return "Instructor{" +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                "departments=" + departments +
                '}';
    }
}
