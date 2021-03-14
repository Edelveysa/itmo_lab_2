package сommands;


import collection.CollectionManager;

public class ShowCommand extends AbstractCommand{
    public ShowCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Выводит все элементы коллекции.");
    }

    @Override
    public void execute() {
        System.out.println("Все элементы коллекции:\n");
        getCollectionManager().getCollection().forEach(o -> System.out.println(o.toString()));
    }
}
