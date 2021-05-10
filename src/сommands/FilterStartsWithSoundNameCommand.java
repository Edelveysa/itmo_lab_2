package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class FilterStartsWithSoundNameCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public FilterStartsWithSoundNameCommand(CollectionManager collectionManager)
    {
        super("filter_starts_with_soundtrack_name name", "Вывести элементы, где название саундрека начинается с заданной подстроки.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String arg) {
        try {
            if(arg.isEmpty()) throw new EmptyExecuteArgumentException();
            if(arg.equals(" ")) throw new EmptyExecuteArgumentException();
            collectionManager.filterSoundCollection(arg);
            return true;
        }catch (EmptyExecuteArgumentException e){
            System.out.println("Введите подстроку!");
        }
        return false;
    }
}
