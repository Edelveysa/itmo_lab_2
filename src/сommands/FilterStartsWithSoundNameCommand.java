package сommands;

import collection.CollectionManager;

public class FilterStartsWithSoundNameCommand extends AbstractCommand{
    public FilterStartsWithSoundNameCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Вывести элементы, где название саундрека начинается с заданной подстроки.");
    }

    @Override
    void execute() {

    }
}
