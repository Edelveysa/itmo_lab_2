package сommands;


import exceptions.EmptyCollectionException;
import managers.CollectionManager;

public class ClearCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager)
    {
        super("clear", "Очищает коллекцию.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute()
    {
        try {
            if(collectionManager.getHumans().isEmpty()) throw new EmptyCollectionException();
            collectionManager.clearCollection();
            return true;
        } catch (EmptyCollectionException exception) {
            System.out.println("Коллекция пустая.");
        }
        return false;

    }
}
