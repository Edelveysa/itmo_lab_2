package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import data.HumanBeing;
import managers.HumanBeingBuilder;

public class UpdateIdCommand extends AbstractCommand{
    public UpdateIdCommand(CollectionManager collectionManager, HumanBeingBuilder builder){
        super(collectionManager, builder);
        setDescription("Обновляет значение элемента по заданному id.");
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
            getCollectionManager().updateIdInCollection(Integer.valueOf(arg), humanBeing);
        }catch (EmptyExecuteArgumentException e){
            System.out.println("Введите id!");
        }catch (NumberFormatException e){
            System.out.println("Введите числовой id!");
        }
    }
}
