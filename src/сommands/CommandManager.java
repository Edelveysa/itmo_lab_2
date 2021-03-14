package сommands;

import java.util.HashMap;
import collection.CollectionManager;

public class CommandManager {

    private CollectionManager collection;
    private static HashMap<String, AbstractCommand> commands = new HashMap<>();

    private CommandManager(CollectionManager collection){
        this.collection = collection;
        commands.put("info", new InfoCommand(collection));
        commands.put("clear", new ClearCommand(collection));
        commands.put("show", new ShowCommand(collection));
        commands.put("add", new AddCommand(collection));
        commands.put("update_id", new UpdateIdCommand(collection));
        commands.put("remove_by_id", new RemoveByIdCommand(collection));
        commands.put("save", new SaveCommand(collection));
        commands.put("execute_script", new ExecuteScriptCommand(collection));
        commands.put("exit", new ExitCommand(collection));
        commands.put("remove_first", new RemoveFirstCommand(collection));
        commands.put("add_if_max", new AddIfMaxCommand(collection));
        commands.put("sort", new SortCommand(collection));
        commands.put("count_less_than_mood", new CountLessThanMoodCommand(collection));
        commands.put("filter_starts_with_soundtrack_name", new FilterStartsWithSoundNameCommand(collection));
        commands.put("print_field_descending_impact_speed", new PrintFieldDescendingImpactSpeedCommand(collection));
    }

    public static HashMap<String, AbstractCommand> getCommands() {
        return commands;
    }


}
