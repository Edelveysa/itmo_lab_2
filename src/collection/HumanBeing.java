package collection;

import exceptions.LowImpactSpeedException;
import exceptions.NoCoordinateException;
import exceptions.NoNameException;
import exceptions.NoSoundtrackException;

import java.time.ZonedDateTime;

public class HumanBeing {
        private static long count = 1;
        private long ID = 1;

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

        public HumanBeing(String name, Coordinates coordinates, boolean realHero, boolean hasToothpick,
                          long impactSpeed, String soundtrackName, int minutesOfWaiting, Mood mood, Car car)
                throws NoNameException, NoCoordinateException, LowImpactSpeedException {
                this.id = Long.valueOf(ID);
                ID = ++count;
                if (name == null || name.equals(" ")) {
                        throw new NoNameException("У вашего человека нет имени.");
                } else {
                        this.name = name;
                }
                if (coordinates == null) {
                        throw new NoCoordinateException("У вашего человека нет координат.");
                } else {
                        this.coordinates = coordinates;
                }
                this.creationDate = giveCreationTime();
                this.realHero = Boolean.valueOf(realHero);
                this.hasToothpick = Boolean.valueOf(hasToothpick);
                if (impactSpeed < -621) {
                        throw new LowImpactSpeedException("У вашего человека скорость удара ниже -621.");
                } else {
                        this.impactSpeed = impactSpeed;
                }
                if (soundtrackName == null){
                        throw new NoSoundtrackException("У вашего героя нет санудретка!");
                }else{
                        this.soundtrackName = soundtrackName;
                }
                if(minutesOfWaiting != 0){
                        this.minutesOfWaiting = Integer.valueOf(minutesOfWaiting);
                } else {
                        this.minutesOfWaiting = Integer.valueOf(0);
                }
                this.mood = mood;
                this.car = car;

        }

        private void setStartId(){

        };
        private ZonedDateTime giveCreationTime(){
                return ZonedDateTime.now();
        }

}
