package сommands;

import exceptions.EmptyExecuteArgumentException;
import managers.CollectionManager;
import managers.CommandManager;
import managers.Console;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Считать и выполнить скрипт из файла.");
    }

}
