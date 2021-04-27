package сommands;

import exceptions.EmptyCollectionException;
import managers.CollectionManager;

public class PrintFieldDescendingImpactSpeedCommand extends AbstractCommand{
    public PrintFieldDescendingImpactSpeedCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Выводит значения ImpactSpeed всех элементов в порядке убывания.");
    }

    @Override
    public void execute() {
        try {
            if (getCollectionManager().getHumans().isEmpty()) throw new EmptyCollectionException();
            getCollectionManager().printLessImpactSpeedCollection();
        } catch (EmptyCollectionException e){
            System.out.println("Коллекция пустая.");
        }
    }
}
