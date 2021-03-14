package сommands;

import collection.CollectionManager;
import collection.HumanBeing;

public class UpdateIdCommand extends AbstractCommand{
    public UpdateIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Обновляет значение элемента по заданному id.");
    }

    @Override
    public void execute(HumanBeing humanBeing, int id) {
        getCollectionManager().getCollection().removeElementAt(id);
        getCollectionManager().getCollection().insertElementAt(humanBeing, id);
    }
}
