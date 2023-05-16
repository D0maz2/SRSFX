package mainClasses;

import java.util.Arrays;
import java.util.Queue;

public class Classroom {
    private int ID;
    private String location;
    private int currentCapacity;
    private int maxCapacity;
    private Course[] coursesHeld;
    private Queue<Student> waitingList;


    public Classroom(int ID, String location, int currentCapacity, int maxCapacity, Course[] coursesHeld, Queue<Student> waitingList)
    {
        this.ID = ID;
        this.location = location;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.coursesHeld = coursesHeld;
        this.waitingList = waitingList;
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
    public Course[] getCoursesHeld()
    {
        return coursesHeld;
    }
    public void setCoursesHeld(Course[] coursesHeld)
    {
        this.coursesHeld = coursesHeld;
    }
    public Queue<Student> getWaitingList()
    {
        return waitingList;
    }
    @Override
    public String toString() {
        return "Classroom{" +
                "ID=" + ID +
                ", location='" + location + '\'' +
                ", currentCapacity=" + currentCapacity +
                ", maxCapacity=" + maxCapacity +
                ", coursesHeld=" + Arrays.toString(coursesHeld) +
                ", waitingList=" + waitingList +
                '}';
    }
}
