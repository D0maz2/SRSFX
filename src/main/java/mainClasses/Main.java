package mainClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] faculties = {"computers and datascience","medicine","engineering"};
        Department d1 = new Department(1000,"CyberSecurity",faculties);
        Department d2 = new Department(1001,"AI",faculties);
        Department d3 = new Department(1002,"Health Care",faculties);
        Department[] DA = {d1,d2,d3};
        int[] p1 = {1,3,6};

        Instructor i1 = new Instructor(1010,"omar","21/4/1960","america", "01074858549",DA);
        Classroom cl1 = new Classroom(1001,"2nd floor",32,50,null,null);
        Course c1 = new Course("Discrete",100,i1,DA,3,942,cl1,p1,"wed",null,null,"A+");
        Course c2 = new Course("DS",101,i1,DA,1,940,cl1,p1,null,null,null,"A-");
        Course c3 = new Course("Algebra",101,i1,DA,1,940,cl1,p1,null,null,null,"B-");
        Course c4 = new Course("Computer Systems",101,i1,DA,1,940,cl1,p1,null,null,null,"C");
        Course c5 = new Course("English",101,i1,DA,1,940,cl1,p1,null,null,null,"C+");
        Course c6 = new Course("Networking",101,i1,DA,1,940,cl1,p1,null,null,null,"D");
        Course[] CA = {c2,c1,c3,c4,c5,c6};


        Student s1 = new Student(101010,"ahmed","21/3/2004","alexandria","01049585839",2022,"Fall",CA,null,d1,3.12,3.0);
        Student s2 = new Student(102391,"ahmed","21/3/2004","cairo","01049585839",2022,"Fall",CA,null,d1,3.12,3.0);
        Student s3 = new Student(338920,"mostafa","21/3/2004","alexandria","01049585839",2022,"Fall",CA,null,d1,3.12,3.0);
        s1.saveData();
        s2.saveData();
        s3.saveData();
       //excelsheet("helloworld.xls",students(s1),header);
        // ArrayList<String> arr = loadexcelString("Employee Sample Data.xls","Data");
        //for (int i = 0;i<arr.size();i++){
            //System.out.println(arr.get(i).getName()+" : "+arr.get(i).getAge());
        //}
    }


    public static ArrayList<Student> students(Student object){
        ArrayList<Person> arr1 = new ArrayList<Person>();
        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(object);
        return arr;
    }
    public static ArrayList<Person> loadexcel(String name) throws IOException {
        ArrayList<Person> arr = new ArrayList<Person>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream(name));
        Sheet sheet = workbook.getSheet("Data");
        Row header = sheet.getRow(0);
        for(int x = 0;x<header.getPhysicalNumberOfCells();x++){
            System.out.print(header.getCell(x));
            if(x < header.getPhysicalNumberOfCells()-1){
                System.out.print(" : ");
            }
        }
        System.out.println("\n");
        int j = 1;
        while (j<sheet.getPhysicalNumberOfRows()) {
            Row row = sheet.getRow(j);
            int i = 0;
            //arr.add(new Student(row.getCell(i).toString(), (int) row.getCell(i + 1).getNumericCellValue()));
            j += 1;
        }
        return arr;
    }
    public static ArrayList<String> loadexcelString(String name,String sheetName) throws IOException {
        ArrayList<String> arr = new ArrayList<String>();
        Workbook workbook = new HSSFWorkbook(new FileInputStream(name));
        Sheet sheet = workbook.getSheet(sheetName);
        for(int j = 0;j<sheet.getPhysicalNumberOfRows();j++) {
            Row header = sheet.getRow(j);
            for (int x = 0; x < header.getPhysicalNumberOfCells(); x++) {
                System.out.print(header.getCell(x));
                if (x < header.getPhysicalNumberOfCells() - 1) {
                    System.out.print("           |           ");
                }
            }
            System.out.println();
        }
//        int j = 1;
//        while (j<sheet.getPhysicalNumberOfRows()){
//            Row row = sheet.getRow(j);
//            System.out.println(sheet.getPhysicalNumberOfRows());
//            System.out.println(row.getPhysicalNumberOfCells());
//            int x = 0;
//            if (x < row.getPhysicalNumberOfCells()) {
//                System.out.print(row.getCell(x)+"\n");
//                x++;
//            }
//            j++;
        //}

//        for(int y = 1;y<sheet.getPhysicalNumberOfRows();y++){
//            Row row = sheet.getRow(y);
//            System.out.print(row.getCell(y-1));
//            if(y < row.getPhysicalNumberOfCells()-1){
//                System.out.print(" : ");
//            }
//        }
        System.out.println("\n");
//        int j = 1;
//        while (j<sheet.getPhysicalNumberOfRows()) {
//            Row row = sheet.getRow(j);
//            int i = 0;
//            j += 1;
//        }
        return arr;
    }
}
