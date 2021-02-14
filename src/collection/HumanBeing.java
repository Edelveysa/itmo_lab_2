package collection;

public class HumanBeing {
        private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Boolean realHero; //Поле не может быть null
        private Boolean hasToothpick; //Поле может быть null
        private long impactSpeed; //Значение поля должно быть больше -621
        private String soundtrackName; //Поле не может быть null
        private Integer minutesOfWaiting; //Поле может быть null
        private Mood mood; //Поле может быть null
        private Car car; //Поле может быть null

}
