package сommands;

import managers.CollectionManager;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Удаляет объект из коллекции по заданному id.");
    }

    @Override
    public void execute(int id) {
        if (id < getCollectionManager().getHumans().size()) {
            getCollectionManager().getHumans().removeElementAt(id);
            getCollectionManager().save();
            System.out.println("Элемент удален.");
        } else {
           System.out.println("Введен несуществующий id.");
        }
    }
}
