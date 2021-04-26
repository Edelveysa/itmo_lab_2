package managers;

import java.util.HashMap;
import java.util.Set;
import exceptions.WrongCommandException;
import сommands.*;

public class CommandManager {

    private CollectionManager collection;
    private HumanBeingBuilder builder;
    private static HashMap<String, AbstractCommand> commands = new HashMap<>();

    public CommandManager(CollectionManager collection, HumanBeingBuilder builder){
        this.collection = collection;
        this.builder = builder;
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

    public void execute(String command, String arg){
        try{
            if(command.isEmpty()) throw new WrongCommandException();

            if(!getCommands().get(command).equals(null)) {
                AbstractCommand abstractCommand = getCommands().get(command);
                switch(command){
                    case "info":
                        InfoCommand infoCommand = (InfoCommand) abstractCommand;
                        infoCommand.execute();
                    case "update_id {element}":
                        UpdateIdCommand updateIdCommand = (UpdateIdCommand) abstractCommand;
                        updateIdCommand.execute(arg);
                    case "remove_first":
                        RemoveFirstCommand removeFirstCommand = (RemoveFirstCommand) abstractCommand;
                        removeFirstCommand.execute();
                    case "add_if_max {element}":
                        AddIfMaxCommand addIfMaxCommand = (AddIfMaxCommand) abstractCommand;
                        addIfMaxCommand.execute(arg);
                    case "sort":
                        SortCommand sortCommand = (SortCommand) abstractCommand;
                        sortCommand.execute();
                    case "count_less_than_mood mood":
                        CountLessThanMoodCommand countLessThanMoodCommand = (CountLessThanMoodCommand) abstractCommand;
                        countLessThanMoodCommand.execute(arg);
                    case "filter_starts_with_soundtrack_name soundtrackName":
                        FilterStartsWithSoundNameCommand filterStartsWithSoundNameCommand = (FilterStartsWithSoundNameCommand) abstractCommand;
                        filterStartsWithSoundNameCommand.execute(arg);
                    case  "print_field_descending_impact_speed":
                        PrintFieldDescendingImpactSpeedCommand printFieldDescendingImpactSpeedCommand = (PrintFieldDescendingImpactSpeedCommand) abstractCommand;
                        printFieldDescendingImpactSpeedCommand.execute();
                    case "remove_by_id id":
                        RemoveByIdCommand removeByIdCommand = (RemoveByIdCommand) abstractCommand;
                        removeByIdCommand.execute(arg);
                    case "save":
                        SaveCommand saveCommand = (SaveCommand) abstractCommand;
                        saveCommand.execute();
                    case "execute_script filename":
                        ExecuteScriptCommand executeScriptCommand = (ExecuteScriptCommand) abstractCommand;
                        executeScriptCommand.execute(arg);
                    case "exit":
                        ExitCommand exitCommand = (ExitCommand) abstractCommand;
                        exitCommand.execute();
                    case "add {element}":
                        AddCommand addCommand = (AddCommand) abstractCommand;
                        addCommand.execute(arg);
                    case "clear":
                        ClearCommand clearCommand = (ClearCommand) abstractCommand;
                        clearCommand.execute();
                    case "show":
                        ShowCommand showCommand = (ShowCommand) abstractCommand;
                        showCommand.execute();
                }

            }else{
                throw new WrongCommandException();
            }

        }catch (WrongCommandException e){
            System.out.println("Введите правильное название команды. Можете воспользоваться командой help.");
        }
    }




}
