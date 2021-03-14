package сommands;


import collection.CollectionManager;

public class ClearCommand extends AbstractCommand{
    public ClearCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Очищает коллекцию.");
    }

    @Override
    public void execute() {
        getCollectionManager().getCollection().clear();
        getCollectionManager().save();
    }
}
