package сommands;

import collection.CollectionManager;

public class InfoCommand extends AbstractCommand{

    public InfoCommand(CollectionManager collectionManager){
        super(collectionManager);

    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции: Stack\n Дата инициализации: " + getCollectionManager().getTime()
                + "\nКоличество элементов: " + getCollectionManager().getCollection().stream().count());
    }
}
