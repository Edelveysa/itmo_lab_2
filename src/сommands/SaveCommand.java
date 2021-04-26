package сommands;

import managers.CollectionManager;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Сохраняет коллекцию в файл.");
    }

    @Override
    void execute(String arg) {
        getCollectionManager().save();
    }
}
