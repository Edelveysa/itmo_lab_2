
import managers.*;
import сommands.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начинается работа программы!");
        HumanBeingBuilder builder = new HumanBeingBuilder(scanner);
        FileManager fileManager = new FileManager("collect");
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(
                new AddCommand(collectionManager, builder),
                new AddIfMaxCommand(collectionManager, builder),
                new ClearCommand(collectionManager),
                new CountLessThanMoodCommand(collectionManager),
                new ExecuteScriptCommand(),
                new ExitCommand(),
                new FilterStartsWithSoundNameCommand(collectionManager),
                new HelpCommand(collectionManager),
                new InfoCommand(collectionManager),
                new PrintFieldDescendingImpactSpeedCommand(collectionManager),
                new RemoveByIdCommand(collectionManager),
                new RemoveFirstCommand(collectionManager),
                new SaveCommand(collectionManager),
                new ShowCommand(collectionManager),
                new SortCommand(collectionManager),
                new UpdateIdCommand(collectionManager, builder));
        Console console = new Console(commandManager, scanner, builder);
        console.interactiveMode();

    }
}
