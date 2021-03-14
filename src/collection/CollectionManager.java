package collection;

import workWithFile.ParserJSON;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Stack;

public class CollectionManager{

    private File jsonCollection;
    private Stack<HumanBeing> collection;
    private ZonedDateTime time;


    public CollectionManager(){
        Stack<HumanBeing> collection = new Stack<HumanBeing>();
        this.time = ZonedDateTime.now();
    }

    public Stack<HumanBeing> getCollection() {
        return collection;
    }
    public void save(){
        try (FileWriter fileWriter = new FileWriter(jsonCollection)){
            fileWriter.write(ParserJSON.writeInJson(collection));
        }  catch (IOException e) {
            System.out.println("Ошибка! Коллекция не может быть сохранена.");
        }
    }
    public String getTime(){
        return time.toString();
    }

}