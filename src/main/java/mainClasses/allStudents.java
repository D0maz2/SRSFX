package mainClasses;

import java.util.ArrayList;

public class allStudents {
    private static ArrayList<Student> Students = new ArrayList<>();

    public void add(Student student){
        Students.add(student);
    }
    public void remove(Student student){
        Students.remove(student);
    }
    public Student get(int i){
        return Students.get(i);
    }
    public int indexOf(Student student){
        return Students.indexOf(student);
    }

    public static Student getStudentByID(String ID){
        for(Student student: Students){
            if(Integer.toString(student.getID()).equals(ID)){
                return  student;
            }
        }
        return null;
    }
}
