package data;

import exceptions.MaxValueExceededException;

public class Coordinates
{
    private Integer x; //Максимальное значение поля: 841, Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(Integer x, Double y)
    {
        setX(x);
        setY(y);
    }

    public void setX(Integer x)
    {
        this.x = x;
    }

    public void setY(Double y)
    {
        this.y = y;
    }

    public Integer getX()
    {
        return x;
    }

    public Double getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "Coordinates {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
