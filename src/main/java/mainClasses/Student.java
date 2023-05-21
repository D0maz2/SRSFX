package mainClasses;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person implements Serializable {
    private static Long serialVersionUID = 6388821038706924043L;
    private int enrolledYear;
    private String enrolledSemester;

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> allRegisteredCourses;
    private Department department;
    private double GPA;
    private double CGPA;


    public Student(int ID, String name, String dateOfBirth, String address, String telephoneNumber, int enrolledYear, String enrolledSemester, ArrayList<Course> allRegisteredCourses, Department department, double GPA, double CGPA)
    {
        super(ID, name, dateOfBirth, address, telephoneNumber);
        this.enrolledYear = enrolledYear;
        this.enrolledSemester = enrolledSemester;
        this.allRegisteredCourses = new ArrayList<Course>();
        allRegisteredCourses.add(new Course());
        this.department = department;
        this.GPA = GPA;
        this.CGPA = CGPA;
        students.add(this);
    }

    public void registerCourse(Course courseName)       //adds the newly registered course to both Current and allRegisteredCourses
    {
        if(arePrerequisitesMet(courseName)){

        }
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
    public boolean arePrerequisitesMet(Course courseName)
    {
        boolean y = false;
        int count = 0;
        for(Course prerequisite : courseName.getPrerequisites()){
            for(Course course : allRegisteredCourses){
                if(course==prerequisite){
                    count++;
                }
            }
        }
        if (count==courseName.getPrerequisites().size()){
            y = true;
        }
        return y;
    }
    public void getTranscript(){

    }

    public void LoadExcelCourse() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Database.xls"));
        Sheet sheet = workbook.getSheet(""+getID());
        if(allRegisteredCourses != null) {
            System.out.println(getAllRegisteredCourses().size());
            Row row;
            for (int i = 0; i < getAllRegisteredCourses().size(); i++) {
                if (sheet.getRow(i + 1) == null) {
                    row = sheet.createRow(i + 1);
                } else {
                    row = sheet.getRow(i + 1);
                }

                row.createCell(10).setCellValue(getAllRegisteredCourses().get(i).getName());
                row.createCell(11).setCellValue(getAllRegisteredCourses().get(i).getCredits());
                row.createCell(12).setCellValue(getAllRegisteredCourses().get(i).getGrade());

                for (int z = 0; z < row.getLastCellNum(); z++) {
                    sheet.autoSizeColumn(z);
                }
            }
        }
        FileOutputStream fos = new FileOutputStream("Database.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("Data saved: " + "Database.xls");
    }

    public void SaveExcelData() throws IOException {
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
        LoadExcelCourse();

    }
    public static void loadStudents() throws IOException, ClassNotFoundException {
        ArrayList<Student> s1 = null;
        FileInputStream fileIn = new FileInputStream("Students.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        s1 = (ArrayList<Student>) in.readObject();
        in.close();
        fileIn.close();
        if (s1 != null) {
            System.out.println("Loaded successfully !");;
        }
        for(int i = 0; i< Objects.requireNonNull(s1).size(); i++){
            Student.getStudents().add(s1.get(i));
        }
    }
    public static void saveStudents(){
        ArrayList<Student> s2 = Student.getStudents();

        try {
            FileOutputStream fileOut = new FileOutputStream("Students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s2);
            out.close();
            fileOut.close();
            System.out.println("Saved to Students.ser");
        } catch (IOException e) {
            System.out.println("Error While serializing");
            e.printStackTrace();
        }
    }
    public static Student getStudentByID(String ID){
        for(Student student: Student.getStudents()){
            if(Integer.toString(student.getID()).equals(ID)){
                return  student;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "Student{" +
                ", ID=" + ID +
                ",\n name='" + name + '\'' +
                ",\n dateOfBirth='" + dateOfBirth + '\'' +
                ",\n address='" + address + '\'' +
                ",\n telephoneNumber='" + telephoneNumber + '\'' +
                "\n enrolledYear=" + enrolledYear +
                ",\n enrolledSemester='" + enrolledSemester + '\'' +
                ",\n allRegisteredCourses=" + allRegisteredCourses +
                ",\n department=" + department.getName() +
                ",\n GPA=" + GPA +
                ",\n CGPA=" + CGPA +
                '}';
    }
}
