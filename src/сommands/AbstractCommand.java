package сommands;

import java.util.Objects;

public abstract class AbstractCommand
{

    private String name;
    private String description;

    public AbstractCommand(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public boolean execute(String argument)
    {
        return false;
    };
    public boolean execute()
    {
        return false;
    }


    /**
     * @return Возвращает имя команды.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Возвращает описание команды.
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "AbstractCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCommand that = (AbstractCommand) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description);
    }
}
