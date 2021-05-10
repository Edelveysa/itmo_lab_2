package managers;

import data.HumanBeing;
import data.Mood;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager
{

    private FileManager fileManager;
    private Stack<HumanBeing> humans = new Stack<HumanBeing>();
    private LocalDateTime time;

    public CollectionManager(FileManager fileManager)
    {
        this.time = null;
        this.fileManager = fileManager;
        load();
    }

    private void load()
    {
        this.time = LocalDateTime.now();
        this.humans = fileManager.read();
        sortCollection();
        System.out.println("Коллекция загружена!");
    }

    public Stack<HumanBeing> getHumans()
    {
        return humans;
    }

    public String getTime()
    {
        return time.toString();
    }

    public void addToCollection(HumanBeing humanBeing)
    {
        humans.push(humanBeing);
        System.out.println("Элемент добавлен в коллекцию.");
    }

    public String typeOfCollection()
    {
        return humans.getClass().getName();
    }

    public void clearCollection()
    {
        humans.clear();
        System.out.println("Коллекция очищена.");
    }

    public void saveCollection()
    {
        fileManager.write(humans);
    }

    public void addMaxToCollection(HumanBeing humanBeing)
    {
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

    public static Long generateID()
    {
        return Long.valueOf(Math.round(Math.random()*1000));
    }

    public void sortCollection()
    {
        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getId());
        comparator.thenComparing(obj -> obj.getCoordinates().getX());
        comparator.thenComparing(obj -> obj.getCoordinates().getY());
        comparator.thenComparing(obj -> obj.getImpactSpeed());
        Collections.sort(getHumans(), comparator);
    }

    public void countLessMoodInCollection(Mood mood)
    {
        System.out.println(humans
                .stream()
                .filter(humanBeing -> humanBeing.getMood().getNumber() < Mood.findNumber(mood.name()))
                .count());

    }

    public void filterSoundCollection(String str)
    {
        humans.stream()
                .filter(obj -> obj.getSoundtrackName().startsWith(str))
                .forEach(obj -> System.out.println(obj.toString()));
    }

    public void printLessImpactSpeedCollection()
    {
        List<HumanBeing> list = getHumans();
        Comparator<HumanBeing> comparator = Comparator.comparing(obj->obj.getImpactSpeed());
        Collections.sort(list, comparator);
        Collections.reverse(list);
        list.stream().forEach(obj -> System.out.println(obj.toString()));

    }

    public void removeByIdInCollection(int id)
    {
        HumanBeing human = humans
                            .stream()
                            .filter(obj -> (obj.getId() == id))
                            .findFirst()
                            .orElse(null);
        humans.remove(human);
    }

    public void removeFirstInCollection()
    {
        humans.remove(0);
    }

    public void updateIdInCollection(int id, HumanBeing humanBeing)
    {
        removeByIdInCollection(id);
        humans.add(humanBeing);
        System.out.println("Элемент исправлен! Вы можете вызвать команду \'show\' для проверки!");
    }

    public void showCollection()
    {
        humans.stream().forEach(obj -> System.out.println(obj.toString()));
    }

}


