package mainClasses;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Student extends Person{
    private int enrolledYear;
    private String enrolledSemester;
    private ArrayList<Course> allRegisteredCourses;
    private ArrayList<Course> currentRegisteredCourses;
    private Department department;
    private double GPA;
    private double CGPA;


    public Student(int ID, String name, String dateOfBirth, String address, String telephoneNumber, int enrolledYear, String enrolledSemester, ArrayList<Course> allRegisteredCourses, ArrayList<Course> currentRegisteredCourses, Department department, double GPA, double CGPA)
    {
        super(ID, name, dateOfBirth, address, telephoneNumber);
        this.enrolledYear = enrolledYear;
        this.enrolledSemester = enrolledSemester;
        this.allRegisteredCourses = allRegisteredCourses;
        this.currentRegisteredCourses = currentRegisteredCourses;
        this.department = department;
        this.GPA = GPA;
        this.CGPA = CGPA;
    }
    public void registerCourse(Course courseName)       //adds the newly registered course to both Current and allRegisteredCourses
    {
       // if(arePrerequisitesMet(courseName)){
            courseName.getStudents().add(this);
            courseName.getClassroom().setCurrentCapacity((courseName.getClassroom().getCurrentCapacity())+1);
       // }
    }
    public int getEnrolledYear()
    {
        return enrolledYear;
    }
    public void setEnrolledYear(int enrolledYear)
    {
        this.enrolledYear = enrolledYear;
    }
    public String getEnrolledSemester()
    {
        return enrolledSemester;
    }
    public void setEnrolledSemester(String enrolledSemester)
    {
        this.enrolledSemester = enrolledSemester;
    }
    public ArrayList<Course> getAllRegisteredCourses()
    {
        return allRegisteredCourses;
    }
    public void setAllRegisteredCourses(ArrayList<Course> allRegisteredCourses)
    {
        this.allRegisteredCourses = allRegisteredCourses;
    }
    public ArrayList<Course> getCurrentRegisteredCourses()
    {
        return currentRegisteredCourses;
    }
    public void setCurrentRegisteredCourses(ArrayList<Course> currentRegisteredCourses)
    {
        this.currentRegisteredCourses = currentRegisteredCourses;
    }
    public Department getDepartment()
    {
        return department;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public double getGPA()
    {
        return GPA;
    }
    public void setGPA(double GPA)
    {
        this.GPA = GPA;
    }
    public double getCGPA()
    {
        return CGPA;
    }
    public void setCGPA(double CGPA)
    {
        this.CGPA = CGPA;
    }
//    public boolean arePrerequisitesMet(Course courseName)
//    {
//        boolean y = false;
//        int count = 0;
//        for(Course prerequisite : courseName.getPrerequisites()){
//            for(Course course : allRegisteredCourses){
//                if(course==prerequisite){
//                    count++;
//                }
//            }
//        }
//        if (count==courseName.getPrerequisites().size()){
//            y = true;
//        }
//        return y;
//    }
    public void getTranscript(){

    }

    public void loadCourse() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
        Sheet sheet = workbook.getSheet(""+getID());
        System.out.println(getAllRegisteredCourses().size());
        Row row;
        for (int i = 0;i<getAllRegisteredCourses().size();i++){
            if(sheet.getRow(i+1) == null) {row = sheet.createRow(i+1);}

            else {row = sheet.getRow(i+1);}

            row.createCell(10).setCellValue(getAllRegisteredCourses().get(i).getName());
            row.createCell(11).setCellValue(getAllRegisteredCourses().get(i).getCredits());
            row.createCell(12).setCellValue(getAllRegisteredCourses().get(i).getGrade());

            for (int z = 0; z < row.getLastCellNum(); z++) {
                sheet.autoSizeColumn(z);
            }
        }
        FileOutputStream fos = new FileOutputStream("Database.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("Data saved: " + "Database.xls");
    }

    public void saveData() throws IOException {
        String[] header = {"Name","ID","Date of Birth","Telephone Number","Address","Department","GPA","CGPA","Enrolment Year","Enrolment Semester","Courses","Credits","Grade"};
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
        Sheet sheet;
        if(workbook.getSheet(""+getID()) != null) {
            sheet = workbook.getSheet(""+getID());
        }
        else{
            sheet = workbook.createSheet(""+getID());
        }
        Row data_row = sheet.createRow(0);
        int i = 0;
        for(String j: header) {
            data_row.createCell(i).setCellValue(j);
            i++;
        }
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(getName());
            row.createCell(1).setCellValue(getID());
            row.createCell(2).setCellValue(getDateOfBirth());
            row.createCell(3).setCellValue(getTelephoneNumber());
            row.createCell(4).setCellValue(getAddress());
            row.createCell(5).setCellValue(getDepartment().getName());
            row.createCell(6).setCellValue(getGPA());
            row.createCell(7).setCellValue(getCGPA());
            row.createCell(8).setCellValue(getEnrolledYear());
            row.createCell(9).setCellValue(getEnrolledSemester());
            for (int z = 0; z < row.getLastCellNum(); z++) {
                sheet.autoSizeColumn(z);
            }
        FileOutputStream fos = new FileOutputStream("Database.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("Data saved: " + "Database.xls");
        //loadCourse();

    }


    @Override
    public String toString() {
        return "Student{" +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                "enrolledYear=" + enrolledYear +
                ", enrolledSemester='" + enrolledSemester + '\'' +
                ", allRegisteredCourses=" + allRegisteredCourses.toString() +
                ", currentRegisteredCourses=" + currentRegisteredCourses.toString() +
                ", department=" + department +
                ", GPA=" + GPA +
                ", CGPA=" + CGPA +
                '}';
    }
}
