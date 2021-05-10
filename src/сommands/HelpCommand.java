package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;

public class HelpCommand extends AbstractCommand
{
    private CollectionManager collectionManager;
    public HelpCommand(CollectionManager collectionManager)
    {
        super("help", "Отображает список всех доступных команд.");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute()
    {
        return true;
    }
}
