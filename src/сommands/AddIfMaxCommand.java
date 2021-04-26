package сommands;

import data.HumanBeing;
import exceptions.EmptyCollectionException;
import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import managers.HumanBeingBuilder;


public class AddIfMaxCommand extends AbstractCommand{
    public AddIfMaxCommand(CollectionManager collectionManager, HumanBeingBuilder builder){
        super(collectionManager, builder);
        setDescription("Добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента в этой коллекции.\nТо есть, если его имя стоит выше по алфавиту.");
    }

    @Override
    public void execute(String arg) {
        try{
            if(!arg.isEmpty()) throw new EmptyExecuteArgumentException();
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
            getCollectionManager().addMaxToCollection(humanBeing);
        }catch (EmptyExecuteArgumentException e){
            System.out.println("У команды нет аргументов.");
        }
    }
}
