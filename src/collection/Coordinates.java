package collection;

import exceptions.MaxValueExceededException;

public class Coordinates {
    private Integer x; //Максимальное значение поля: 841, Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(Integer x, Double y){
        if(x > 841){
            throw new MaxValueExceededException("Превышено максимально значение координаты Х - 841.");
        } else if (x == null) {
            throw new NullPointerException("У вас не задана координата Х");
        } else {
            this.x = x;
        }
        if (y == null) {
            throw new NullPointerException("У вас не задана координата Y");
        } else {
            this.y = y;
        }
    }

}
