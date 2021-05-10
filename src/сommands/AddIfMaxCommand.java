package сommands;

import data.HumanBeing;
import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import managers.HumanBeingBuilder;


public class AddIfMaxCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    private HumanBeingBuilder builder;

    public AddIfMaxCommand(CollectionManager collectionManager, HumanBeingBuilder builder)
    {
        super("add_if_max", "Добавляет новый элемент в коллекцию, если сила удара наибольшая.");
        this.builder = builder;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String arg)
    {
        try{
            if(!arg.isEmpty()) throw new EmptyExecuteArgumentException();
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
            collectionManager.addMaxToCollection(humanBeing);
            return true;
        }catch(EmptyExecuteArgumentException e)
        {
            System.out.println("У команды нет аргументов.");
        }
        return false;
    }
}
