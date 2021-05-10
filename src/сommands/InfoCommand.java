package сommands;

import managers.CollectionManager;

public class InfoCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager)
    {
        super("info", "Вывод информации о коллекции");
        this.collectionManager = collectionManager;

    }

    @Override
    public boolean execute()
    {
        System.out.println("Тип коллекции:" + collectionManager.typeOfCollection() +"\n Дата инициализации: "
                + collectionManager.getTime() + "\nКоличество элементов: " + collectionManager.getHumans().stream().count());
        return true;
    }
}
