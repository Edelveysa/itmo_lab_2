package сommands;

import managers.CollectionManager;

public class SaveCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public SaveCommand(CollectionManager collectionManager)
    {
        super("save", "Сохраняет коллекцию в файл.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute()
    {
        try {
            collectionManager.saveCollection();
            return true;
        } catch (NullPointerException e){
            System.out.println("Коллекция пустая, увы.");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
