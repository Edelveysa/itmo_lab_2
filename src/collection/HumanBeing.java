package collection;

import exceptions.LowImpactSpeedException;

import java.time.ZonedDateTime;
import java.util.Comparator;

public class HumanBeing{
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

        public HumanBeing(String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick,
                          long impactSpeed, String soundtrackName, Integer minutesOfWaiting, Mood mood, Car car){
                this.id = Long.valueOf(ID);
                ID = ++count;
                if (name == null || name.equals(" ")) {
                        throw new NullPointerException("У вашего человека нет имени.");
                } else {
                        this.name = name;
                }
                if (coordinates == null) {
                        throw new NullPointerException("У вашего человека нет координат.");
                } else {
                        this.coordinates = coordinates;
                }
                this.creationDate = giveCreationTime();
                if (realHero != null){
                        this.realHero = Boolean.valueOf(realHero);
                } else {
                        throw new NullPointerException("У вашего человека неизвестно, является ли он героем.");
                }
                this.hasToothpick = hasToothpick;
                if (impactSpeed < -621) {
                        throw new LowImpactSpeedException("У вашего человека скорость удара ниже -621.");
                } else {
                        this.impactSpeed = impactSpeed;
                }
                if (soundtrackName == null){
                        throw new NullPointerException("У вашего героя нет санудретка.");
                }else{
                        this.soundtrackName = soundtrackName;
                }
                this.minutesOfWaiting = minutesOfWaiting;
                this.mood = mood;
                this.car = car;

        }

        private void setStartId(){

        };
        private ZonedDateTime giveCreationTime(){
                return ZonedDateTime.now();
        }
        public Mood getMood() {
                return mood;
        }
        public String getName() {
                return name;
        }
        public long getImpactSpeed() {
                return impactSpeed;
        }
}
