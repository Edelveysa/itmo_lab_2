package managers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import managers.CollectionManager;
import сommands.*;

public class CommandManager {

    private CollectionManager collection;
    private static HashMap<String, AbstractCommand> commands = new HashMap<>();

    private CommandManager(CollectionManager collection, HumanBeingBuilder builder){
        this.collection = collection;
        commands.put("info", new InfoCommand(collection));
        commands.put("clear", new ClearCommand(collection));
        commands.put("show", new ShowCommand(collection));
        commands.put("add {element}", new AddCommand(collection, builder));
        commands.put("update_id {element}", new UpdateIdCommand(collection, builder));
        commands.put("remove_by_id id", new RemoveByIdCommand(collection));
        commands.put("save", new SaveCommand(collection));
        commands.put("execute_script filename", new ExecuteScriptCommand(collection));
        commands.put("exit", new ExitCommand(collection));
        commands.put("remove_first", new RemoveFirstCommand(collection));
        commands.put("add_if_max {element}", new AddIfMaxCommand(collection, builder));
        commands.put("sort", new SortCommand(collection));
        commands.put("count_less_than_mood mood", new CountLessThanMoodCommand(collection));
        commands.put("filter_starts_with_soundtrack_name soundtrackName", new FilterStartsWithSoundNameCommand(collection));
        commands.put("print_field_descending_impact_speed", new PrintFieldDescendingImpactSpeedCommand(collection));
    }

    public static HashMap<String, AbstractCommand> getCommands() {
        return commands;
    }

    public static Set<String> getCommandsNames(){
        return commands.keySet();
    }


}
