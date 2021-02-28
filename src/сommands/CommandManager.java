package сommands;

import java.util.HashMap;
import collection.CollectionManager;

public class CommandManager {

    private CollectionManager collection;
    private HashMap<String, AbstractCommand> commands = new HashMap<>();

    private CommandManager(CollectionManager collection){
        this.collection = collection;
        commands.put("info", new InfoCommand(collection));
        commands.put("clear", new ClearCommand(collection));
        commands.put("show", new ShowCommand(collection));
        commands.put("add", new AddCommand(collection));
        commands.put("update_id", new UpdateIdCommand(collection));
        commands.put("remove_by_id", new RemoveByIdCommand(collection));

    }
}
