package сommands;

import collection.CollectionManager;

public class HelpCommand extends AbstractCommand{

    public HelpCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Отображает список всех доступных команд.");
    }

    @Override
    public void execute() {
        System.out.println(CommandManager.getCommands().toString());
    }
}
