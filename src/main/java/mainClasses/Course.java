package mainClasses;

import java.util.Arrays;

public class Course {
    private String name;
    private int courseNumber;
    private Instructor instructor;
    private Department[] departments;
    private int term;
    private int credits;
    private Classroom classroom;
    private int[] periods;
    private String dayOfTheWeek;
    private Course[] prerequisites;
    private String[] textbooks;
    private String grade;


    public Course(String name, int courseNumber, Instructor instructor, Department[] departments, int term, int credits, Classroom classroom, int[] periods, String dayOfTheWeek, Course[] prerequisites, String[] textbooks, String grade)
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
    public Department[] getDepartments()
    {
        return departments;
    }
    public void setDepartments(Department[] departments)
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
    public Course[] getPrerequisites()
    {
        return prerequisites;
    }
    public void setPrerequisites(Course[] prerequisites)
    {
        this.prerequisites = prerequisites;
    }
    public String[] getTextbooks()
    {
        return textbooks;
    }
    public void setTextbooks(String[] textbooks)
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
    @Override
    public String toString()
    {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                ", instructor=" + instructor +
                ", departments=" + Arrays.toString(departments) +
                ", term=" + term +
                ", credits=" + credits +
                ", classroom=" + classroom +
                ", periods=" + Arrays.toString(periods) +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", prerequisites=" + Arrays.toString(prerequisites) +
                ", textbooks=" + Arrays.toString(textbooks) +
                ", grade='" + grade + '\'' +
                '}';
    }
}
