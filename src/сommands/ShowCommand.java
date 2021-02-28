package сommands;


import collection.CollectionManager;

public class ShowCommand extends AbstractCommand{
    public ShowCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Выводит все элементы коллекции.");
    }

    @Override
    void execute() {

    }
}
