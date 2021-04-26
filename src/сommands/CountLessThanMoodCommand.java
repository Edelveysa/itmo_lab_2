package сommands;

import exceptions.EmptyCollectionException;
import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import data.HumanBeing;
import data.Mood;

import java.util.Stack;

public class CountLessThanMoodCommand extends AbstractCommand{
    public CountLessThanMoodCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Вывести количество элементов, значение поля mood которых меньше заданного.");
    }

    @Override
    public void execute(String arg) {
        Mood mood;
        try {
            switch (arg) {
                case "APATHY":
                    mood = Mood.APATHY;
                    break;
                case"SORROW":
                    mood = Mood.SORROW;
                    break;
                case "GLOOM":
                    mood = Mood.GLOOM;
                    break;
                case "RAGE":
                    mood = Mood.RAGE;
                    break;
                default:
                    throw new EmptyExecuteArgumentException();
            }
            getCollectionManager().countLessMoodInCollection(mood);
        } catch (EmptyExecuteArgumentException e){
            System.out.println("Вы ввели \"пустое\" настроение" );
        }
    }
}
