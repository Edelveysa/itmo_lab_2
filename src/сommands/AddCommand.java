package сommands;

import managers.CollectionManager;
public class AddCommand extends AbstractCommand{
    public AddCommand(CollectionManager collectionManager){
        super(collectionManager);
        setDescription("Добавление нового элемента в коллекцию.");
    }

    @Override
    public void execute(String arg) {
        getCollectionManager().getHumans().addElement(ParserJSON.readFromJson(arg));
        getCollectionManager().save();
        System.out.println("Элемент добавлен в коллекцию.");
    }

}
