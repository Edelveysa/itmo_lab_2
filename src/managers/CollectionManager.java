package managers;

import data.HumanBeing;
import java.time.ZonedDateTime;
import java.util.Stack;

public class CollectionManager{

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
        time = ZonedDateTime.now();
        humans = fileManager.read();
    }

    public Stack<HumanBeing> getHumans() {
        return humans;
    }

    public String getTime(){
        return time.toString();
    }

    public void addToCollection(HumanBeing humanBeing){
        humans.push(humanBeing);
    }

    public String typeOfCollection(){
        return humans.getClass().getName();
    }

    public void clearCollection(){
        humans.clear();
    }

    public void save(){
        fileManager.write(humans);
    }

    public int sizeOfCollection(){
        return humans.size();
    }




}