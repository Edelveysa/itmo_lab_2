import managers.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начинается работа программы!");
        HumanBeingBuilder builder = new HumanBeingBuilder(scanner);
        FileManager fileManager = new FileManager();
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(collectionManager, builder);

        Console console = new Console(commandManager, scanner, builder);
        console.interactiveMode();

    }
}
