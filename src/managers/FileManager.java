package managers;

import data.HumanBeing;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Класс FileManager, отвечающий за работу с файлом.
 * @author Delsa
 * @version 1.0
 */

public class FileManager {
    /** Поле файл */
    private File file;
    private String filename;
    private Gson gson = new Gson();

    public FileManager() {
//        this.file = new File(System.getenv("COLLECT"));
//        this.file = new File("collect");
        this.filename = "collect";
    }

    /**
     * Функция записи в файл{@link FileManager#file}
     * @param data - данные для записи в файл.
     */

    public void write(Stack<HumanBeing> data){
        FileWriter writer = null;
        try{
            writer = new FileWriter(file);
            writer.write(gson.toJson(data));
            System.out.println("Коллекция успешно записана в файл.");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            }catch (IOException e){
                e.printStackTrace();

            }
        }

    }

    /**
     * Функция для чтения из файла{@link FileManager#file}
     * @return Возвращает строку данных.
     */

    public Stack<HumanBeing> read(){
        try (Scanner scanFile = new Scanner(new File(this.filename))){
            Stack<HumanBeing> collection = new Stack<>();
            Type collectionType = new TypeToken<Stack<HumanBeing>>(){}.getType();
            collection = gson.fromJson(scanFile.nextLine().trim(), collectionType);
            System.out.println("Коллекция успешно загружена.");
            return collection;
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден.");
        }catch (NoSuchElementException e){
            System.out.println("Информация в файле отсутствует.");
        }catch (NullPointerException e){
            System.out.println("Искомая коллекция отсутствует в файле.");
        }catch (JsonParseException e){
            System.out.println("Ошибка чтения из json.");
        }
        catch (Exception e) {
            System.out.println(32);
            e.printStackTrace();

        }
        System.out.println(12);
        return new Stack<HumanBeing>();
    }


}
