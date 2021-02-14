package collection;

public class Car {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null

    public Car(String name, Boolean cool){
        if(name == null){
            throw new NullPointerException("Не задано название машины.");
        } else {
            this.name = name;
        }
        if (cool == null){
            throw new NullPointerException("Не указано, крутая ли машина.");
        }
    }
}