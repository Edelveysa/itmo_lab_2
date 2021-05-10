package сommands;

import managers.CollectionManager;

public class RemoveFirstCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public RemoveFirstCommand(CollectionManager collectionManager)
    {
        super("remove_first", "Удалить первый элемент в коллекции.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute() {
        try{
            collectionManager.removeFirstInCollection();
            return true;
        }catch (Exception e){
            System.out.println();
        }
        return false;
    }
}
