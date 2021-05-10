package сommands;

public class ExitCommand extends AbstractCommand
{
    public ExitCommand()
    {
        super("exit", "Завершение программы без сохранения в файл.");
    }

    @Override
    public boolean execute()
    {
        System.out.println("Мы были рады работать с вами :)");
        System.exit(0);
        return true;
    }
}
