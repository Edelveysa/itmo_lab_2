package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Удаляет объект из коллекции по заданному id.");
    }

    @Override
    public void execute(String arg) {
        try {
            if(arg.isEmpty()) throw new EmptyExecuteArgumentException();
            if(arg.equals(" ")) throw new EmptyExecuteArgumentException();
            getCollectionManager().removeByIdInCollection(Integer.valueOf(arg));
        }  catch (EmptyExecuteArgumentException e){
            System.out.println("Введите id!");
        } catch (NumberFormatException e){
            System.out.println("...это точно было число?");
        }

    }
}
