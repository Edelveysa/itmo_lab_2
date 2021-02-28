package сommands;

import collection.CollectionManager;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Завершение программы без сохранения в файл.");
    }

    @Override
    void execute() {

    }
}
