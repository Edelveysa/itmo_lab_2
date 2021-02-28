package сommands;

import collection.CollectionManager;

public class AddIfMaxCommand extends AbstractCommand{
    public AddIfMaxCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента в этой коллекции.");
    }

    @Override
    void execute() {

    }
}
