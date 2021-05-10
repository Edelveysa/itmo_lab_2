package managers;

import java.util.ArrayList;
import java.util.List;
import сommands.*;

public class CommandManager
{

    private static List<AbstractCommand> commands = new ArrayList<>();
    private AddCommand addCommand;
    private AddIfMaxCommand addIfMaxCommand;
    private ClearCommand clearCommand;
    private CountLessThanMoodCommand countLessThanMoodCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private ExitCommand exitCommand;
    private FilterStartsWithSoundNameCommand filterStartaWithSoundNameCommand;
    private HelpCommand helpCommand;
    private InfoCommand infoCommand;
    private PrintFieldDescendingImpactSpeedCommand printFieldDescendingImpactSpeedCommand;
    private RemoveByIdCommand removeByIdCommand;
    private RemoveFirstCommand removeFirstCommand;
    private SaveCommand saveCommand;
    private ShowCommand showCommand;
    private SortCommand sortCommand;
    private UpdateIdCommand updateIdCommand;

    public CommandManager( AddCommand addCommand, AddIfMaxCommand addIfMaxCommand, ClearCommand clearCommand, CountLessThanMoodCommand countLessThanMoodCommand,
                                ExecuteScriptCommand executeScriptCommand, ExitCommand exitCommand, FilterStartsWithSoundNameCommand filterStartWithSoundNameCommand,
                                HelpCommand helpCommand, InfoCommand infoCommand, PrintFieldDescendingImpactSpeedCommand printFieldDescendingImpactSpeedCommand,
                                RemoveByIdCommand removeByIdCommand, RemoveFirstCommand removeFirstCommand, SaveCommand saveCommand, ShowCommand showCommand,
                                SortCommand sortCommand, UpdateIdCommand updateIdCommand)
    {
        this.addCommand = addCommand;
        this.addIfMaxCommand = addIfMaxCommand;
        this.clearCommand = clearCommand;
        this.countLessThanMoodCommand = countLessThanMoodCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.exitCommand = exitCommand;
        this.filterStartaWithSoundNameCommand = filterStartWithSoundNameCommand;
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.printFieldDescendingImpactSpeedCommand = printFieldDescendingImpactSpeedCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.sortCommand = sortCommand;
        this.updateIdCommand = updateIdCommand;

        commands.add(addCommand);
        commands.add(addIfMaxCommand);
        commands.add(clearCommand);
        commands.add(countLessThanMoodCommand);
        commands.add(executeScriptCommand);
        commands.add(exitCommand);
        commands.add(filterStartWithSoundNameCommand);
        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(printFieldDescendingImpactSpeedCommand);
        commands.add(removeByIdCommand);
        commands.add(removeFirstCommand);
        commands.add(saveCommand);
        commands.add(showCommand);
        commands.add(sortCommand);
        commands.add(updateIdCommand);

    }

    /**
     * Дает информацию об используемых командах.
     * @return Статус выполнения команды.
     */
    public boolean help()
    {
        if (helpCommand.execute()) {
            for (AbstractCommand command : commands) {
                System.out.println(command.getName() + ": " + command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean info()
    {
        return infoCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean show()
    {
        return showCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean save()
    {
        return saveCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean clear()
    {
        return clearCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean add()
    {
        return addCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean updateById(String arg)
    {
        return updateIdCommand.execute(arg);
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean countLessMood(String arg)
    {
        return countLessThanMoodCommand.execute(arg);
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean exit()
    {
        return exitCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean addIfMax(String arg)
    {
        return addIfMaxCommand.execute(arg);
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean filterSound(String arg)
    {
        return filterStartaWithSoundNameCommand.execute(arg);
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean printDescendingImpact()
    {
        return printFieldDescendingImpactSpeedCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean removeFirst()
    {
        return removeFirstCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean removeById(String arg)
    {
        return removeByIdCommand.execute(arg);
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean sort()
    {
        return sortCommand.execute();
    }

    /**
     * Исполнение команды.
     * @return Статус выполнения команды.
     */
    public boolean executeScript(String arg)
    {
        return executeScriptCommand.execute(arg);
    }
}
