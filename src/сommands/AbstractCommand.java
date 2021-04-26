package сommands;

import managers.CollectionManager;
import data.HumanBeing;

public abstract class AbstractCommand {

    private String description;
    private CollectionManager collectionManager;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public void execute(){
        System.out.println("Нет аргументов");
    };

     public void execute(String arg) {
         execute();
     }

     public void execute(int id){
         execute();
     }

     public void execute(HumanBeing humanBeing, int id){
         execute();
     }
}
