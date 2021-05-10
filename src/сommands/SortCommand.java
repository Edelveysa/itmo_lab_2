package сommands;

import managers.CollectionManager;

public class SortCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public SortCommand(CollectionManager collectionManager)
    {
        super("sort", "Сортировать в естественном порядке.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute()
    {
        try {
            collectionManager.sortCollection();
            System.out.println("Коллекция отсортирована.");
            return true;
        }catch(Exception e){
            System.out.println();
        }
        return false;
    }
}
