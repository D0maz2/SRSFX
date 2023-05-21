package mainClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        String[] faculties = {"Computers and Data Science","Science","Engineering"};
//        Department d1 = new Department(1000,"Cyber Security",faculties);
//        Department d2 = new Department(1001,"Intelligent Systems",faculties);
//        Department d3 = new Department(1002,"Data Science",faculties);
//        Department d4 = new Department(1003,"Business Intelligence",faculties);
//        Department d5 = new Department(1004,"Media",faculties);
//
//ArrayList<Department> depsAll = new ArrayList<>();
//    depsAll.add(d1);
//    depsAll.add(d2);
//    depsAll.add(d3);
//    depsAll.add(d4);
//    depsAll.add(d5);
//
//    ArrayList<Department> depIntro = new ArrayList<>();
//    depIntro.add(d1);
//    depIntro.add(d2);
//
//    ArrayList<Department> depCYBER = new ArrayList<>();
//    depCYBER.add(d1);
//
//        int[] p1 = {1,3};
//        int[] p2 = {2,4};
//        int[] p3 = {8,7};
//        int[] p4 = {7,5};
//        int[] p5 = {6,8};
//        ArrayList<String> textbooks = new ArrayList<>();
//        textbooks.add("PDF1");
//        textbooks.add("PDF2");
//        textbooks.add("PDF3");
//        textbooks.add("PDF4");
//        textbooks.add("PDF5");
//
//        Instructor i1 = new Instructor(1010,"omar","21/4/1960","florida,america", "01074858549",Department.getDeps());
//        Instructor i2 = new Instructor(1020,"mohamed","11/6/1970","berlin,germany", "011574839213",Department.getDeps());
//        Instructor i3 = new Instructor(1030,"ebrahim","15/9/1965","cairo,egypt", "01243528876",Department.getDeps());
//        Instructor i4 = new Instructor(1040,"mahmoud","7/12/1977","riyad,saudi arabia", "01510144055",Department.getDeps()) ;
//        Instructor i5 = new Instructor(1050,"soha","28/4/1980","london,uk" , "0125341688" ,Department.getDeps()) ;
//
//        Classroom cl1 = new Classroom(1001,"204",32,50,null);
//        Classroom cl2 = new Classroom(1002,"207",44,50,null);
//        Classroom cl3 = new Classroom(1003,"106",25,30,null);
//        Classroom cl4 = new Classroom(1004,"404",42,50,null);
//        Classroom cl5 = new Classroom(1005,"417",30,50,null);
//       Course c1 =  new Course("Discrete",100,i1,depsAll,1,942,cl1,p1,"Wednesday",null,textbooks,"null");
//       Course c2 =  new Course("Linear Algebra",102,i3,depsAll,1,940,cl1,p3,"Wednesday",null,textbooks,"null");
//        Course c3 = new Course("Computer Networks",103,i5,depCYBER,1,940,cl2,p5,"Wednesday",null,textbooks,"null");
//        Course c4 = new Course("Programming I",104,i5,depsAll,1,960,cl3,p4,"Thursday",null,textbooks,"null");
//        Course c5 = new Course("Calculus",105,i2,depsAll,2,1000,cl1,p5,"Thursday",null,textbooks,"null");
//
//ArrayList<Course> preAI = new ArrayList<>();
//preAI.add(c1);
//ArrayList<Course> preSecurity = new ArrayList<>();
//preSecurity.add(c3);
//ArrayList<Course> preProg = new ArrayList<>();
//preProg.add(c4);
//
//
//
//
//
//
//      Course c6 =  new Course("Intro to AI",106,i2,depIntro,2,900,cl1,p2,"Thursday",preAI,textbooks,"null");
//        Course c7 = new Course("Network Security",107,i4,depCYBER,2,840,cl1,p4,"Thursday",preSecurity,textbooks,"null");
//        Course c8 = new Course("Programming II",108,i3,depsAll,2,940,cl1,p5,"Wednesday",preProg,textbooks,"null");
//
//        ArrayList<Course> Ccl1 = new ArrayList<>();
//        Ccl1.add(c1);
//        Ccl1.add(c2);
//        Ccl1.add(c5);
//        Ccl1.add(c6);
//        Ccl1.add(c7);
//        Ccl1.add(c8);
//
//        ArrayList<Course> Ccl2 = new ArrayList<>();
//        Ccl2.add(c3);
//
//        ArrayList<Course> Ccl3 = new ArrayList<>();
//        Ccl3.add(c4);
//
//        cl1.setCoursesHeld(Ccl1);
//        cl2.setCoursesHeld(Ccl2);
//        cl3.setCoursesHeld(Ccl3);
//
//        Course.saveCourses();
//
//
//        ArrayList<Course> hamo = new ArrayList<>();
//        hamo.add(c6);
//        hamo.add(c8);
//
//        ArrayList<Course> ahmed = new ArrayList<>();
//        ahmed.add(c7);
//        ahmed.add(c8);
//
//                         //THE PREBUILT OBJECTS
//        new Student(101010,"Mohammed Mostafa","11/5/1992","alexandria","01265739953",2010,"Fall",hamo,d2,3.27,2.5);
//       new Student(102391,"Ahmed Salah","21/3/2004","cairo","01049585839",2022,"Fall",ahmed,d1,3.12,3.0);
//
//
//
//        Student.saveStudents();
//        new Student(338920,"mostafa","9/7/2004","fayom","01193627853",2022,"Fall",Course.getCourses(),d3,2.7,3.3);
//         new Student(204451,"omar","5/1/2004","alexandria","010593852101",2022,"Fall",Course.getCourses(),d5,3.88,3.6);
//         new Student(2674839,"abd allah","25/12/2002","alexandria","0115427793",2020,"Fall",Course.getCourses(),d1,2.2,2.8);
//        new Student(696969,"abd allah","25/12/2002","alexandria","0115427793",2020,"Fall",Course.getCourses(),d1,2.2,2.8);
//        Student.loadStudents();
//
//Student.saveStudents();
//for(int i =0;i<Student.getStudents().size();i++) {
//    System.out.println(Student.getStudents().get(i).getID());
//}
        //Student.saveStudents();
//        Student.loadStudents();
//        for(int i =0;i<Student.getStudents().size();i++) {
//            System.out.println(Student.getStudents().get(i).getID());
//        }


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
