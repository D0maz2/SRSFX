package mainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Department  implements Serializable {
    private int ID;
    private String name;
    private String[] faculties;
    private static ArrayList<Department> deps = new ArrayList<>();

    public static ArrayList<Department> getDeps() {
        return deps;
    }

    public Department(int ID, String name, String[] faculties)
    {
        this.ID = ID;
        this.name = name;
        this.faculties = faculties;
        deps.add(this);
    }
    public int getID()
    {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String[] getFaculties()
    {
        return faculties;
    }
    public void setFaculties(String[] faculties)
    {
        this.faculties = faculties;
    }
    @Override
    public String toString()
    {
        return "Department{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", faculties=" + Arrays.toString(faculties) +
                '}';
    }
}
