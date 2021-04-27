package сommands;

import data.HumanBeing;
import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import managers.HumanBeingBuilder;

public class AddCommand extends AbstractCommand{
    public AddCommand(CollectionManager collectionManager, HumanBeingBuilder builder){
        super(collectionManager, builder);
        setDescription("Добавление нового элемента в коллекцию.");
    }

    @Override
    public void execute(String arg) {
        try{
            if(arg.isEmpty()) throw new EmptyExecuteArgumentException();
            HumanBeing humanBeing = new HumanBeing(
                    getCollectionManager().generateID(),
                    getHumanBeingBuilder().scanName(),
                    getHumanBeingBuilder().scanCoordinates(),
                    getHumanBeingBuilder().scanRealHero(),
                    getHumanBeingBuilder().scanHasToothPick(),
                    getHumanBeingBuilder().scanImpactSpeed(),
                    getHumanBeingBuilder().scanSoundtrackName(),
                    getHumanBeingBuilder().scanMinutesOfWaiting(),
                    getHumanBeingBuilder().scanMood(),
                    getHumanBeingBuilder().scanCar()
            );
            getCollectionManager().addToCollection(humanBeing);
        }catch (EmptyExecuteArgumentException e){
            System.out.println("У команды нет аргументов.");
        }
    }
}
