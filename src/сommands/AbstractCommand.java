package сommands;

import collection.CollectionManager;

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

    abstract void execute();
}
