package сommands;

import managers.CollectionManager;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Считать и выполнить скрипт из файла.");
    }

    @Override
    void execute() {

    }
}
