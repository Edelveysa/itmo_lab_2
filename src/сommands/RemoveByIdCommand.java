package сommands;

import collection.CollectionManager;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Удаляет объект из коллекции по заданному id.");
    }

    @Override
    void execute() {

    }
}
