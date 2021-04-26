package сommands;

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
        Stack<HumanBeing> stack = getCollectionManager().getHumans();
        System.out.println(stack
                .stream()
                .filter(humanBeing -> humanBeing.getMood().getNumber() < Mood.findNumber(arg))
                .count());
    }
}
