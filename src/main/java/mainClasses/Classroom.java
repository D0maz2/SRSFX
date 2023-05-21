package mainClasses;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Classroom implements Serializable {
    private int ID;
    private String location;
    private int currentCapacity;
    private int maxCapacity;
    private ArrayList<Course> coursesHeld;
    private static ArrayList<Classroom> classrooms = new ArrayList<>();

    public static ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public Classroom(int ID, String location, int currentCapacity, int maxCapacity, ArrayList<Course> coursesHeld)
    {
        this.ID = ID;
        this.location = location;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.coursesHeld = coursesHeld;
        classrooms.add(this);
    }
    public void saveData() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Classrooms.xls"));
        Sheet sheet;
        if(workbook.getSheet(""+getID()) != null) {
            sheet = workbook.getSheet(""+getID());
        }
        else{
            sheet = workbook.createSheet(""+getID());
        }

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Location");
        row.createCell(2).setCellValue("Current Capacity");
        row.createCell(3).setCellValue("Max Capacity");
        row.createCell(4).setCellValue("Courses Held");
        for (int z = 0; z < row.getLastCellNum(); z++) {
            sheet.autoSizeColumn(z);
        }
        Row Data_row = sheet.createRow(1);
        Data_row.createCell(0).setCellValue(ID+"");
        Data_row.createCell(1).setCellValue(location);
        Data_row.createCell(2).setCellValue(currentCapacity);
        Data_row.createCell(3).setCellValue(maxCapacity);
        FileOutputStream fos = new FileOutputStream("Classrooms.xls");
        workbook.write(fos);
        fos.close();
        loadCourses();
    }
    public static void LoadExcelClassrooms() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Classrooms.xls"));
        for (int x = 0;x<workbook.getNumberOfSheets();x++) {
            ArrayList<String> courseName = new ArrayList<>();
            ArrayList<Course> finalCourses = new ArrayList<>();
            Sheet sheet = workbook.getSheet(workbook.getSheetAt(x).getSheetName());
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                courseName.add(sheet.getRow(i).getCell(4).toString());
            }
            for (int i = 0; i < courseName.size(); i++) {
                for (int j = 0; j < Course.getCourses().size(); j++) {
                    if (Objects.equals(courseName.get(i), Course.getCourses().get(j).getName())) {
                        finalCourses.add(Course.getCourses().get(j));
                    }
                }
            }
            String location_id = sheet.getRow(1).getCell(1).toString();
            int ID_1 = Integer.parseInt(sheet.getRow(1).getCell(0).toString());
            int currentCap = (int) sheet.getRow(1).getCell(2).getNumericCellValue();
            int maxCap = (int) sheet.getRow(1).getCell(3).getNumericCellValue();
            Classroom classes = new Classroom(ID_1,location_id,currentCap,maxCap,finalCourses);
        }
    }
    public void loadCourses() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Classrooms.xls"));
        Sheet sheet = workbook.getSheet(""+getID());
        Row row;
        for (int i =0;i<coursesHeld.size();i++){
            if(sheet.getRow(i+1) == null) {
                row = sheet.createRow(i+1);
            }

            else {
                row = sheet.getRow(i+1);
            }
            row.createCell(4).setCellValue(coursesHeld.get(i).getName());
        }
        FileOutputStream fos = new FileOutputStream("Classrooms.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("Data saved: " + "Classrooms.xls");
    }
    public static ArrayList<Course> load_from_excel_courses(String id) throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("Classrooms.xls"));
            ArrayList<String> courseNames = new ArrayList<>();
            ArrayList<Course> finalCourses = new ArrayList<>();
            Sheet sheet = workbook.getSheet(id);
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
            return finalCourses;
    }
    public static void saveClassrooms(){
        ArrayList<Classroom> s2 = Classroom.getClassrooms();

        try {
            FileOutputStream fileOut = new FileOutputStream("Classrooms.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s2);
            out.close();
            fileOut.close();
            System.out.println("Saved to Classrooms.ser");
        } catch (IOException e) {
            System.out.println("Error While serializing - Classrooms - ");
            e.printStackTrace();
        }
    }

    public static void loadClassrooms() throws IOException, ClassNotFoundException {
        ArrayList<Classroom> s1 = null;
        FileInputStream fileIn = new FileInputStream("Classrooms.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        s1 = (ArrayList<Classroom>) in.readObject();
        in.close();
        fileIn.close();
        if (s1 != null) {
            System.out.println("Loaded successfully !");;
        }
        for(int i = 0; i< Objects.requireNonNull(s1).size(); i++){
            Classroom.getClassrooms().add(s1.get(i));
        }
    }
    public int getID()
    {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public String getLocation()
    {
        return location;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }
    public int getCurrentCapacity()
    {
        return currentCapacity;
    }
    public void setCurrentCapacity(int currentCapacity)
    {
        this.currentCapacity = currentCapacity;
    }
    public int getMaxCapacity()
    {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity)
    {
        this.maxCapacity = maxCapacity;
    }
    public ArrayList<Course> getCoursesHeld()
    {
        return coursesHeld;
    }
    public void setCoursesHeld(ArrayList<Course> coursesHeld)
    {
        this.coursesHeld = coursesHeld;
    }
    @Override
    public String toString() {
        return "Classroom{" +
                "ID=" + ID +
                ", location='" + location + '\'' +
                ", currentCapacity=" + currentCapacity +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
