package сommands;

import collection.CollectionManager;

public class UpdateIdCommand extends AbstractCommand{
    public UpdateIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Обновляет значение элемента по заданному id.");
    }

    @Override
    void execute() {

    }
}
