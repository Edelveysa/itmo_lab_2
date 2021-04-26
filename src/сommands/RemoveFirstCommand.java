package сommands;

import managers.CollectionManager;

public class RemoveFirstCommand extends AbstractCommand{
    public RemoveFirstCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Удалить первый элемент в коллекции.");
    }

    @Override
    public void execute() {
        System.out.println("Элемент " + getCollectionManager().getHumans().pop().toString() +
                " удален из коллекции.");
    }
}
