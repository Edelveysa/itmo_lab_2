package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class RemoveByIdCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager collectionManager)
    {
        super("remove_by_id id", "Удаляет объект из коллекции по заданному id.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String arg)
    {
        try {
            if(arg.isEmpty()) throw new EmptyExecuteArgumentException();
            if(arg.equals(" ")) throw new EmptyExecuteArgumentException();
            collectionManager.removeByIdInCollection(Integer.valueOf(arg));
            return true;
        }  catch (EmptyExecuteArgumentException e){
            System.out.println("Введите id!");
        } catch (NumberFormatException e){
            System.out.println("...это точно было число?");
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
