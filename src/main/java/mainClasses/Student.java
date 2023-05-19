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
    private static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Student> getStudents() {
        return students;
    }


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
        students.add(this);
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
    {this.allRegisteredCourses = allRegisteredCourses;}
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
    public static ArrayList<Student> getAllStudents() {
        return allStudents;
    }
    public static void setAllStudents(ArrayList<Student> allStudents) {
        Student.allStudents = allStudents;
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
    public static Student getStudentByID(String ID){
        for(Student student: allStudents){
            if(Integer.toString(student.getID()).equals(ID)){
                return  student;
            }
        }
        return null;
    }

    public static void loadStudents(){
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
            Student s1 = new Student(ID, name, date, address, phone, EY, ES, finalCourses, null, department, GPA, CGPA);
        }
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
