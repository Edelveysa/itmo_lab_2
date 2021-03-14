package сommands;

import collection.CollectionManager;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Удаляет объект из коллекции по заданному id.");
    }

    @Override
    public void execute(int id) {
        if (id < getCollectionManager().getCollection().size()) {
            getCollectionManager().getCollection().removeElementAt(id);
            getCollectionManager().save();
            System.out.println("Элемент удален.");
        } else {
           System.out.println("Введен несуществующий id.");
        }
    }
}
