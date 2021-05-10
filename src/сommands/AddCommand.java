package сommands;

import data.HumanBeing;
import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import managers.HumanBeingBuilder;

public class AddCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    private HumanBeingBuilder builder;
    
    public AddCommand(CollectionManager collectionManager, HumanBeingBuilder builder)
    {
        super("add ", "Добавление нового элемента в коллекцию.");
        this.builder = builder;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute()
    {
        try{
            HumanBeing humanBeing = new HumanBeing(
                    collectionManager.generateID(),
                    builder.scanName(),
                    builder.scanCoordinates(),
                    builder.scanRealHero(),
                    builder.scanHasToothPick(),
                    builder.scanImpactSpeed(),
                    builder.scanSoundtrackName(),
                    builder.scanMinutesOfWaiting(),
                    builder.scanMood(),
                    builder.scanCar()
            );
            collectionManager.addToCollection(humanBeing);
            return true;
        }catch (Exception e)
        {
            System.out.println("У команды нет аргументов.");
        }
        return false;
    }
}
