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
        if(!getCollectionManager().getHumans().isEmpty()) {
            getCollectionManager().clearCollection();
            System.out.println("Коллекция очищена.");
        } else{
            System.out.println("Коллекция пустая.");
        }
    }
}
