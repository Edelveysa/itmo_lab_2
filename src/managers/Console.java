package managers;

import exceptions.EmptyExecuteArgumentException;
import exceptions.ScriptRecursionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {

    private CommandManager commandManager;
    private HumanBeingBuilder builder;
    private Scanner scanner;
    private List<String> scriptFileNames = new ArrayList<>();

    public Console(CommandManager commandManager, Scanner scanner, HumanBeingBuilder builder) {
        this.commandManager = commandManager;
        this.scanner = scanner;
        this.builder = builder;
    }

    public void interactiveMode() {
        String[] userCommand = {"", ""};
        try {
            do {
                userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                executeCommand(userCommand);
            } while (true);
        } catch (Exception e) {}
    }

    public void scriptMode(String fileName) {
        String[] userCommand = {"", ""};
        scriptFileNames.add(fileName);
        try (Scanner scriptScanner = new Scanner(new File(fileName))){
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner oldScanner = builder.getScanner();
            builder.setScanner(scriptScanner);
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                System.out.println("Выполняется команда: " + userCommand[0]);
                if (userCommand[0].equals("execute_script")) {
                    for (String script : scriptFileNames) {
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                executeCommand(userCommand);
            } while (scriptScanner.hasNextLine());
            builder.setScanner(oldScanner);
        } catch (FileNotFoundException e) {
            System.out.println("Файл со скриптом не найден!");
        } catch (NoSuchElementException e) {
            System.out.println("Файл со скриптом пуст!");
        } catch (ScriptRecursionException e) {
            System.out.println("Скрипты не могут вызываться рекурсивно");
        }
    }



    private void executeCommand(String command[]){
        if(!command[0].equals("execute_script")){
            commandManager.execute(command[0], command[1]);
        }else{
            try {
                if (command[1].isEmpty()) throw new EmptyExecuteArgumentException();
                scriptMode(command[1]);
            }catch (EmptyExecuteArgumentException e){
                System.out.println("Введите имя файла.");
            }

        }
    }

}
