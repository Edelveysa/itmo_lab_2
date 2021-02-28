package сommands;

import collection.CollectionManager;

public class CountLessThanMoodCommand extends AbstractCommand{
    public CountLessThanMoodCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Вывести количество элементов, значение поля mood которых меньше заданногою");
    }

    @Override
    void execute() {

    }
}
