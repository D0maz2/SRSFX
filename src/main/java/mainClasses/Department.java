package mainClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
    public static void saveDepartments(){
        ArrayList<Department> s2 = Department.getDeps();

        try {
            FileOutputStream fileOut = new FileOutputStream("Departments.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s2);
            out.close();
            fileOut.close();
            System.out.println("Saved to Departments.ser");
        } catch (IOException e) {
            System.out.println("Error While serializing - Departments - ");
            e.printStackTrace();
        }
    }

    public static void loadDepartments() throws IOException, ClassNotFoundException {
        ArrayList<Department> s1 = null;
        FileInputStream fileIn = new FileInputStream("Departments.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        s1 = (ArrayList<Department>) in.readObject();
        in.close();
        fileIn.close();
        if (s1 != null) {
            System.out.println("Loaded successfully !");;
        }
        for(int i = 0; i< Objects.requireNonNull(s1).size(); i++){
            Department.getDeps().add(s1.get(i));
        }
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
