package сommands;

import managers.CollectionManager;
import data.HumanBeing;
import workWithFile.ParserJSON;
import java.util.Comparator;

public class AddIfMaxCommand extends AbstractCommand{
    public AddIfMaxCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента в этой коллекции.\nТо есть, если его имя стоит выше по алфавиту.");
    }

    @Override
    public void execute(String arg) {
        HumanBeing maxHB = getCollectionManager().getHumans()
                .stream()
                .min(Comparator.comparing(String::valueOf))
                .get();
        if(chooseMax(maxHB, ParserJSON.readFromJson(arg))){
            getCollectionManager().getHumans().addElement(ParserJSON.readFromJson(arg));
            System.out.println("Элемент добавлен в коллекцию.");
        }else {
            System.out.println("Элемент не добавлен в коллекцию.");
        }
    }

    private boolean chooseMax(HumanBeing hb1, HumanBeing hb2){
        Comparator<HumanBeing> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        if(comparator.compare(hb1, hb2) < 0){
                return true;
        } else {
            return false;
        }

    }
}
