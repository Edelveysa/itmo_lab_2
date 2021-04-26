package сommands;


import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class ClearCommand extends AbstractCommand{
    public ClearCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Очищает коллекцию.");
    }

    @Override
    public void execute() {
            getCollectionManager().clearCollection();
    }
}
