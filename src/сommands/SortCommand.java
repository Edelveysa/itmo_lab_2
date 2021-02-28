package сommands;

import collection.CollectionManager;

public class SortCommand extends AbstractCommand{
    public SortCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Сортировать в естественном порядке.");
    }

    @Override
    void execute() {

    }
}
