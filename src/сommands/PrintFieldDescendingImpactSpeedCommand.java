package сommands;

import exceptions.EmptyCollectionException;
import managers.CollectionManager;

public class PrintFieldDescendingImpactSpeedCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public PrintFieldDescendingImpactSpeedCommand(CollectionManager collectionManager){
        super("print_field_descending_impact_speed", "Выводит значения ImpactSpeed всех элементов в порядке убывания.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute() {
        try {
            if (collectionManager.getHumans().isEmpty()) throw new EmptyCollectionException();
            collectionManager.printLessImpactSpeedCollection();
            return true;
        } catch (EmptyCollectionException e){
            System.out.println("Коллекция пустая.");
        }
        return false;
    }
}
