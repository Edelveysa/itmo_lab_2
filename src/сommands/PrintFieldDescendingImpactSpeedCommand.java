package сommands;

import managers.CollectionManager;

public class PrintFieldDescendingImpactSpeedCommand extends AbstractCommand{
    public PrintFieldDescendingImpactSpeedCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Выводит значения ImpactSpeed всех элементов в порядке убывания.");
    }

    @Override
    public void execute() {
        getCollectionManager().printLessImpactSpeedCollection();
    }
}
