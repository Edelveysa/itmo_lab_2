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
        commands.put("add", new AddCommand(collection, builder));
        commands.put("update_id", new UpdateIdCommand(collection, builder));
        commands.put("remove_by_id", new RemoveByIdCommand(collection));
        commands.put("save", new SaveCommand(collection));
        commands.put("execute_script", new ExecuteScriptCommand(collection));
        commands.put("exit", new ExitCommand(collection));
        commands.put("remove_first", new RemoveFirstCommand(collection));
        commands.put("add_if_max", new AddIfMaxCommand(collection, builder));
        commands.put("sort", new SortCommand(collection));
        commands.put("count_less_than_mood", new CountLessThanMoodCommand(collection));
        commands.put("filter_starts_with_soundtrack_name", new FilterStartsWithSoundNameCommand(collection));
        commands.put("print_field_descending_impact_speed", new PrintFieldDescendingImpactSpeedCommand(collection));
        commands.put("help", new HelpCommand(collection));
    }

    public static HashMap<String, AbstractCommand> getCommands() {
        return commands;
    }

    public static Set<String> getCommandsNames(){
        return commands.keySet();
    }

    public CollectionManager getCollection() {
        return collection;
    }

    public void execute(String command, String arg){
        try{
            if(command.isEmpty()) throw new WrongCommandException();
            if(getCommands().containsKey(command)) {
                AbstractCommand abstractCommand = getCommands().get(command);
                switch(command){
                    case "info":
                        InfoCommand infoCommand = (InfoCommand) abstractCommand;
                        infoCommand.execute();
                        break;
                    case "update_id":
                        UpdateIdCommand updateIdCommand = (UpdateIdCommand) abstractCommand;
                        updateIdCommand.execute(arg);
                        break;
                    case "remove_first":
                        RemoveFirstCommand removeFirstCommand = (RemoveFirstCommand) abstractCommand;
                        removeFirstCommand.execute();
                    case "add_if_max":
                        AddIfMaxCommand addIfMaxCommand = (AddIfMaxCommand) abstractCommand;
                        addIfMaxCommand.execute(arg);
                        break;
                    case "sort":
                        SortCommand sortCommand = (SortCommand) abstractCommand;
                        sortCommand.execute();
                        break;
                    case "count_less_than_mood":
                        CountLessThanMoodCommand countLessThanMoodCommand = (CountLessThanMoodCommand) abstractCommand;
                        countLessThanMoodCommand.execute(arg);
                        break;
                    case "filter_starts_with_soundtrack_name":
                        FilterStartsWithSoundNameCommand filterStartsWithSoundNameCommand = (FilterStartsWithSoundNameCommand) abstractCommand;
                        filterStartsWithSoundNameCommand.execute(arg);
                        break;
                    case  "print_field_descending_impact_speed":
                        PrintFieldDescendingImpactSpeedCommand printFieldDescendingImpactSpeedCommand = (PrintFieldDescendingImpactSpeedCommand) abstractCommand;
                        printFieldDescendingImpactSpeedCommand.execute();
                        break;
                    case "remove_by_id":
                        RemoveByIdCommand removeByIdCommand = (RemoveByIdCommand) abstractCommand;
                        removeByIdCommand.execute(arg);
                        break;
                    case "save":
                        SaveCommand saveCommand = (SaveCommand) abstractCommand;
                        saveCommand.execute();
                        break;
                    case "execute_script filename":
                        ExecuteScriptCommand executeScriptCommand = (ExecuteScriptCommand) abstractCommand;
                        executeScriptCommand.execute(arg);
                        break;
                    case "exit":
                        ExitCommand exitCommand = (ExitCommand) abstractCommand;
                        exitCommand.execute();
                        break;
                    case "add":
                        AddCommand addCommand = (AddCommand) abstractCommand;
                        addCommand.execute(arg);
                        break;
                    case "clear":
                        ClearCommand clearCommand = (ClearCommand) abstractCommand;
                        clearCommand.execute();
                        break;
                    case "show":
                        ShowCommand showCommand = (ShowCommand) abstractCommand;
                        showCommand.execute();
                        break;
                    case "help":
                        HelpCommand helpCommand = (HelpCommand) abstractCommand;
                        helpCommand.execute();
                        break;
                }

            }else{
                throw new WrongCommandException();
            }

        }catch (WrongCommandException e){
            System.out.println("Введите правильное название команды. Можете воспользоваться командой help.");
        }
    }





}
