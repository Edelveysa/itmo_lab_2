package сommands;


import exceptions.EmptyCollectionException;
import managers.CollectionManager;

public class ShowCommand extends AbstractCommand{
    public ShowCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Выводит все элементы коллекции.");
    }

    @Override
    public void execute() {
        try{
        if (getCollectionManager().getHumans().isEmpty()) throw new EmptyCollectionException();
        System.out.println("Все элементы коллекции:");
        getCollectionManager().getHumans().forEach(obj -> System.out.println(obj.toString()));
        } catch (EmptyCollectionException e){
            System.out.println("Коллекция пустая.");
        }

    }
}
