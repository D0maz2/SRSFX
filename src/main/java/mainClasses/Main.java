package mainClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String[] faculties = {"computers and datascience","medicine","engineering"};
        Department d1 = new Department(1000,"Cyber Security",faculties);
        Department d2 = new Department(1001,"Intelligent Systems",faculties);
        Department d3 = new Department(1002,"Data Science",faculties);
        Department d4 = new Department(1003,"Business Intelligence",faculties);
        Department d5 = new Department(1004,"Media",faculties);
        


        int[] p1 = {1,3,6};

        Instructor i1 = new Instructor(1010,"omar","21/4/1960","florida,america", "01074858549",Department.getDeps());
        Instructor i2 = new Instructor(1020,"mohamed","11/6/1970","berlin,germany", "011574839213",Department.getDeps());
        Instructor i3 = new Instructor(1030,"ebrahim","15/9/1965","cairo,egypt", "01243528876",Department.getDeps());
        Instructor i4 = new Instructor(1040,"mahmoud","7/12/1977","riyad,saudi arabia", "01510144055",Department.getDeps()) ;
        Instructor i5 = new Instructor(1050,"soha","28/4/1980","london,uk" , "0125341688" ,Department.getDeps()) ;
        Classroom cl1 = new Classroom(1001,"204",32,50,Course.getCourses());
        Classroom cl2 = new Classroom(1002,"207",44,50,Course.getCourses());
        Classroom cl3 = new Classroom(1003,"106",25,30,Course.getCourses());
        Classroom cl4 = new Classroom(1004,"404",42,50,Course.getCourses());
        Classroom cl5 = new Classroom(1005,"417",30,50,Course.getCourses());



        new Course("Discrete",100,i1,Department.getDeps(),3,942,cl1,p1,"wed",null,null,"A+");
        new Course("DS",102,i2,Department.getDeps(),1,940,cl1,p1,null,null,null,"A-");
        new Course("Algebra",103,i3,Department.getDeps(),1,940,cl1,p1,null,null,null,"B-");
        new Course("Computer Systems",104,i4,Department.getDeps(),1,940,cl1,p1,null,null,null,"C");
        new Course("English",105,i5,Department.getDeps(),1,940,cl1,p1,null,null,null,"C+");

        //new Student(101010,"mohamed","11/5/1992","alexandria","01265739953",2010,"Fall",Course.getCourses(),d2,3.27,2.5);
       //new Student(102391,"ahmed","21/3/2004","cairo","01049585839",2022,"Fall",Course.getCourses(),d1,3.12,3.0);
      //  new Student(338920,"mostafa","9/7/2004","fayom","01193627853",2022,"Fall",Course.getCourses(),d3,2.7,3.3);
//         new Student(204451,"omar","5/1/2004","alexandria","010593852101",2022,"Fall",Course.getCourses(),d5,3.88,3.6);
//         new Student(2674839,"abd allah","25/12/2002","alexandria","0115427793",2020,"Fall",Course.getCourses(),d1,2.2,2.8);
//        new Student(696969,"abd allah","25/12/2002","alexandria","0115427793",2020,"Fall",Course.getCourses(),d1,2.2,2.8);

//Student.saveStudents();
//for(int i =0;i<Student.getStudents().size();i++) {
//    System.out.println(Student.getStudents().get(i).getID());
//}


    }
    public static void loadStudent() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
        for (int x = 0;x<workbook.getNumberOfSheets();x++) {
            ArrayList<String> courseNames = new ArrayList<>();
            ArrayList<Course> finalCourses = new ArrayList<>();
            Sheet sheet = workbook.getSheet(workbook.getSheetAt(x).getSheetName());
            String d1 = sheet.getRow(1).getCell(5).toString();
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                courseNames.add(sheet.getRow(i).getCell(10).toString());
            }

            for (int i = 0; i < courseNames.size(); i++) {
                for (int j = 0; j < Course.getCourses().size(); j++) {
                    if (Objects.equals(courseNames.get(i), Course.getCourses().get(j).getName())) {
                        finalCourses.add(Course.getCourses().get(j));
                    }
                }
            }
            Department department = null;
            for (int i = 0; i < Department.getDeps().size(); i++) {
                if (Objects.equals(d1, Department.getDeps().get(i).getName())) {
                    department = Department.getDeps().get(i);
                }
            }
            String name = sheet.getRow(1).getCell(0).toString();
            int ID = (int) sheet.getRow(1).getCell(1).getNumericCellValue();
            String date = sheet.getRow(1).getCell(2).toString();
            String phone = sheet.getRow(1).getCell(3).toString();
            String address = sheet.getRow(1).getCell(4).toString();
            Double GPA = sheet.getRow(1).getCell(6).getNumericCellValue();
            Double CGPA = sheet.getRow(1).getCell(7).getNumericCellValue();
            int EY = (int) sheet.getRow(1).getCell(8).getNumericCellValue();
            String ES = sheet.getRow(1).getCell(9).toString();
            Student s1 = new Student(ID, name, date, address, phone, EY, ES, finalCourses, department, GPA, CGPA);
        }
    }
    public static void loadInstructor() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database_instructors.xls"));
        for (int x = 0;x<workbook.getNumberOfSheets();x++) {
            ArrayList<String> depsNames = new ArrayList<>();
            ArrayList<Department> finalDeps = new ArrayList<>();
            Sheet sheet = workbook.getSheet(workbook.getSheetAt(x).getSheetName());
            String d1 = sheet.getRow(1).getCell(5).toString();
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                depsNames.add(sheet.getRow(i).getCell(5).toString());
            }

            for (int i = 0; i < depsNames.size(); i++) {
                for (int j = 0; j < Department.getDeps().size(); j++) {
                    if (Objects.equals(depsNames.get(i), Department.getDeps().get(j).getName())) {
                        finalDeps.add(Department.getDeps().get(j));
                    }
                }
            }
            String name = sheet.getRow(1).getCell(0).toString();
            int ID = (int) sheet.getRow(1).getCell(1).getNumericCellValue();
            String date = sheet.getRow(1).getCell(2).toString();
            String phone = sheet.getRow(1).getCell(3).toString();
            String address = sheet.getRow(1).getCell(4).toString();
            Instructor i1 = new Instructor(ID, name, date, address, phone, finalDeps);
        }


    }
}
