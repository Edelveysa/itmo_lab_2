package сommands;

import managers.CollectionManager;

public class SortCommand extends AbstractCommand{
    public SortCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Сортировать в естественном порядке.");
    }

    @Override
    public void execute() {
        getCollectionManager().sortCollection();
        System.out.println("Коллекция отсортирована.");
    }
}
