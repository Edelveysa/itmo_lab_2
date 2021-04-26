package сommands;

import managers.CollectionManager;

public class SortCommand extends AbstractCommand{
    public SortCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Сортировать в естественном порядке.");
    }

    @Override
    public void execute() {
        getCollectionManager().getHumans().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Коллекция отсортирована.");
    }
}
