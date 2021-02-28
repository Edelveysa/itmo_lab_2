package сommands;

import collection.CollectionManager;

public class AddCommand extends AbstractCommand{
    public AddCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Добавление нового элемента в коллекцию.");
    }

    @Override
    void execute() {

    }
}
