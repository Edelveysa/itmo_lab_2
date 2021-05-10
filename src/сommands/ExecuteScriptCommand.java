package сommands;

import exceptions.EmptyExecuteArgumentException;

public class ExecuteScriptCommand extends AbstractCommand
{
    public ExecuteScriptCommand() {
        super("execute_script filename", "исполнить скрипт из указанного файла");
    }

    /**
     * Выполняет скрипт.
     * @return Статус выполнения команды.
     */
    @Override
    public boolean execute(String arg) {
        try {
            if (arg.isEmpty()) throw new EmptyExecuteArgumentException();
            System.out.println("Скрипт выполняется!");
            return true;
        } catch (EmptyExecuteArgumentException exception) {
            System.out.println("У этой команды нет параметров!");
        }
        return false;
    }

}
