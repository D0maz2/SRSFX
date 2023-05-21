package mainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Course implements Serializable {

    private String name;
    private int courseNumber;
    private Instructor instructor;
    private ArrayList<Department> departments;
    private static ArrayList<Course> courses = new ArrayList<>();

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    private int term;
    private int credits;
    private Classroom classroom;
    private int[] periods;
    private String dayOfTheWeek;
    private ArrayList<Course> prerequisites;
    private ArrayList<String> textbooks;
    private String grade;


    public Course(String name, int courseNumber, Instructor instructor, ArrayList<Department> departments, int term, int credits, Classroom classroom, int[] periods, String dayOfTheWeek, ArrayList<Course> prerequisites, ArrayList<String> textbooks, String grade)
    {
        this.name = name;
        this.courseNumber = courseNumber;
        this.instructor = instructor;
        this.departments = departments;
        this.term = term;
        this.credits = credits;
        this.classroom = classroom;
        this.periods = periods;
        this.dayOfTheWeek = dayOfTheWeek;
        this.prerequisites = prerequisites;
        this.textbooks = textbooks;
        this.grade = grade;
        courses.add(this);
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getCourseNumber()
    {
        return courseNumber;
    }
    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }
    public Instructor getInstructor()
    {
        return instructor;
    }
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    public ArrayList<Department> getDepartments()
    {
        return departments;
    }
    public void setDepartments(ArrayList<Department> departments)
    {
        this.departments = departments;
    }
    public int getTerm()
    {
        return term;
    }
    public void setTerm(int term)
    {
        this.term = term;
    }
    public int getCredits()
    {
        return credits;
    }
    public void setCredits(int credits)
    {
        this.credits = credits;
    }
    public Classroom getClassroom()
    {
        return classroom;
    }
    public void setClassroom(Classroom classroom)
    {
        this.classroom = classroom;
    }
    public int[] getPeriods()
    {
        return periods;
    }
    public void setPeriods(int[] periods)
    {
        this.periods = periods;
    }
    public String getDayOfTheWeek()
    {
        return dayOfTheWeek;
    }
    public void setDayOfTheWeek(String dayOfTheWeek)
    {
        this.dayOfTheWeek = dayOfTheWeek;
    }
    public ArrayList<Course> getPrerequisites()
    {
        return prerequisites;
    }
    public void setPrerequisites(ArrayList<Course> prerequisites)
    {
        this.prerequisites = prerequisites;
    }
    public ArrayList<String> getTextbooks()
    {
        return textbooks;
    }
    public void setTextbooks(ArrayList<String> textbooks)
    {
        this.textbooks = textbooks;
    }
    public String getGrade()
    {
        return grade;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    public Course getCourseByID(String ID){
        for(Course course: Course.getCourses()){
            if(Integer.toString(course.getCourseNumber()).equals(ID)){
                return  course;
            }
        }
        return null;
    }
    @Override
    public String toString()
    {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                ", instructor=" + instructor +
                ", departments=" + departments.toString() +
                ", term=" + term +
                ", credits=" + credits +
                ", classroom=" + classroom +
                ", periods=" + Arrays.toString(periods) +
                //", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                //", prerequisites=" + prerequisites.toString() +
                //", textbooks=" + textbooks.toString() +
                ", grade='" + grade + '\'' +
                '}';
    }
    public boolean contains(ArrayList<Course> Courses){
        boolean flag = false;
        int count = this.getPrerequisites().size();
        for(Course pre: this.getPrerequisites()){
            for(Course course: Courses){
                if(pre == course){
                    count--;
                }
            }
        }
        if(count==0){
            flag = true;
        }
        return flag;
    }
}
