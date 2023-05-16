package mainClasses;

public abstract class Person {
    protected int ID;
    protected String name;
    protected String dateOfBirth;
    protected String address;
    protected String telephoneNumber;


    public Person(int ID, String name, String dateOfBirth, String address, String telephoneNumber)
    {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
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
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }
    @Override
    public String toString()
    {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}