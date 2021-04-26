package managers;

import data.HumanBeing;
import data.Mood;

import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager{

    private static long NEXT_ID = 0;

    private FileManager fileManager;
    private Stack<HumanBeing> humans;
    private ZonedDateTime time;



    public CollectionManager(FileManager fileManager){
        this.humans = new Stack<HumanBeing>();
        this.time = null;
        this.fileManager = fileManager;
        load();
    }

    private void load(){
        this.time = ZonedDateTime.now();
        this.humans = fileManager.read();
        sortCollection();
    }

    public Stack<HumanBeing> getHumans() {
        return humans;
    }

    public String getTime(){
        return time.toString();
    }

    public void addToCollection(HumanBeing humanBeing){
        getHumans().push(humanBeing);
        System.out.println("Элемент добавлен в коллекциюю");
    }

    public String typeOfCollection(){
        return humans.getClass().getName();
    }

    public void clearCollection(){
        getHumans().clear();
    }

    public void save(){
        fileManager.write(getHumans());
    }

    public void addMaxToCollection(HumanBeing humanBeing) {
        Optional<HumanBeing> max = null;
        try {
            max = getHumans()
                    .stream()
                    .max(Comparator.comparing(obj -> obj.getImpactSpeed()));
        } catch (NullPointerException e) {
            addToCollection(humanBeing);
            System.out.println("Это будет первым элементом в нашей коллекции.");
        } finally {
            if (max.get().getImpactSpeed() < humanBeing.getImpactSpeed()) {
                addToCollection(humanBeing);


            }
        }
    }

    public static Long generateID(){
        return Long.valueOf(++NEXT_ID);
    }

    public void sortCollection(){
        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getId());
        comparator.thenComparing(obj -> obj.getCoordinates().getX());
        comparator.thenComparing(obj -> obj.getCoordinates().getY());
        comparator.thenComparing(obj -> obj.getImpactSpeed());
        Collections.sort(getHumans(), comparator);
    }

    public void countLessMoodInCollection(Mood mood){
        System.out.println(getHumans()
                .stream()
                .filter(humanBeing -> humanBeing.getMood().getNumber() < Mood.findNumber(mood.name()))
                .count());

    }

    public void filterSoundCollection(String str){
        getHumans().stream()
                .filter(obj -> obj.getSoundtrackName().startsWith(str))
                .forEach(obj -> System.out.println(obj.toString()));
    }

    public void printLessImpactSpeedCollection(){
        List<HumanBeing> list = getHumans();
        Comparator<HumanBeing> comparator = Comparator.comparing(obj->obj.getImpactSpeed());
        Collections.sort(list, comparator);
        Collections.reverse(list);
        list.stream().forEach(obj -> obj.toString());

    }

    public void removeByIdInCollection(int id){
        getHumans().remove(id);
    }

    public void removeFirstInCollection(){
        getHumans().remove(0);
    }

    public void updateIdInCollection(int id, HumanBeing humanBeing){
        getHumans().remove(id);
        getHumans().insertElementAt(humanBeing, id);
    }

}


