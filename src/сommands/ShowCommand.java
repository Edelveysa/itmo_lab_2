package сommands;


import exceptions.EmptyCollectionException;
import managers.CollectionManager;

public class ShowCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager)
    {
        super("show", "Выводит все элементы коллекции.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute() {
        try{
            if (collectionManager.getHumans().isEmpty()) throw new EmptyCollectionException();
            System.out.println("Все элементы коллекции:");
            collectionManager.showCollection();
        return true;
        } catch (EmptyCollectionException e){
            System.out.println("Коллекция пустая.");
        }
        return false;
    }
}
