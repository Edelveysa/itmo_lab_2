package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class FilterStartsWithSoundNameCommand extends AbstractCommand{
    public FilterStartsWithSoundNameCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Вывести элементы, где название саундрека начинается с заданной подстроки.");
    }

    @Override
    public void execute(String arg) {
        try {
            if(arg.isEmpty()) throw new EmptyExecuteArgumentException();
            if(arg.equals(" ")) throw new EmptyExecuteArgumentException();
            getCollectionManager().filterSoundCollection(arg);
        }catch (EmptyExecuteArgumentException e){
            System.out.println("Введите подстроку!");
        }
    }
}
