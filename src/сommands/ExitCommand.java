package сommands;

import managers.CollectionManager;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Завершение программы без сохранения в файл.");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
