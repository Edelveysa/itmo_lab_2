package data;

public class Car
{
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null

    public Car(String name, Boolean cool)
    {
        setName(name);
        setCool(cool);
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setCool(Boolean cool)
    {
        this.cool = cool;
    }

    @Override
    public String toString()
    {
        return "Car {" +
                "name='" + name + '\'' +
                ", cool=" + cool +
                '}';
    }
}