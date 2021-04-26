package сommands;

import managers.CollectionManager;

public class InfoCommand extends AbstractCommand{

    public InfoCommand(CollectionManager collectionManager){
        super(collectionManager);

    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции: Stack\n Дата инициализации: " + getCollectionManager().getTime()
                + "\nКоличество элементов: " + getCollectionManager().getHumans().stream().count());
    }
}
