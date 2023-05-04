import java.util.Arrays;

public class Department {
    private int ID;
    private String name;
    private String[] faculties;


    public Department(int ID, String name, String[] faculties)
    {
        this.ID = ID;
        this.name = name;
        this.faculties = faculties;
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
