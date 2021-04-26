package сommands;

import managers.CollectionManager;
import managers.HumanBeingBuilder;

public abstract class AbstractCommand {

    private String description;
    private CollectionManager collectionManager;
    private HumanBeingBuilder humanBeingBuilder;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public AbstractCommand(CollectionManager collectionManager, HumanBeingBuilder humanBeingBuilder){
        this.collectionManager = collectionManager;
        this.humanBeingBuilder = humanBeingBuilder;
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

    public void execute(String arg){};

    public void execute(){
        System.out.println("Нет аргументов.");
    }

    public HumanBeingBuilder getHumanBeingBuilder() {
        return humanBeingBuilder;
    }
}
