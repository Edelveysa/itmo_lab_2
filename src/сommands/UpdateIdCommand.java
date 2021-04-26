package сommands;

import managers.CollectionManager;
import data.HumanBeing;

public class UpdateIdCommand extends AbstractCommand{
    public UpdateIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Обновляет значение элемента по заданному id.");
    }

    @Override
    public void execute(HumanBeing humanBeing, int id) {
        getCollectionManager().getHumans().removeElementAt(id);
        getCollectionManager().getHumans().insertElementAt(humanBeing, id);
    }
}
