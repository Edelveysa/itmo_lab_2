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
 *
 * @version 1.1
 */

public class FileManager
{
    /** Поле объект Gson*/
    private Gson gson = new Gson();
    /** Поле имя файла */
    private String filePath;

    public FileManager(String fileName)
    {
        this.filePath = fileName;
    }

    /**
     * Функция записи в файл.
     * @param data - коллекция для записи в файл.
     */

    public void write(Stack<HumanBeing> data) {
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            writer.write(gson.toJson(data));
            writer.close();
            System.out.println("Коллекция успешна сохранена в файл!");
        }catch (FileNotFoundException e) {
            System.out.println("Возможность записать в файл отсутствует.\nПопытка создания нового файла...");
            writeNew();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Создание нового файла для хранения коллекции.
     */

    public void writeNew() {
        try {
            File file = new File("collection");
            if (file.createNewFile()) {
                System.out.println("Файл создан! Попробуйте сохранить еще раз.");
                setFileName("collection");
            } else throw new IOException();
        } catch (IOException e){
            System.out.println("Нет возможности создать файл");
        }
    }

    /**
     * Функция для чтения из файла.
     * @return Возвращает коллекцию с данными.
     */

    public Stack<HumanBeing> read()
    {
        try (Scanner scanFile = new Scanner(new File(this.filePath))){
            Stack<HumanBeing> collection;
            Type collectionType = new TypeToken<Stack<HumanBeing>>(){}.getType();
            collection = gson.fromJson(scanFile.nextLine().trim(), collectionType);
            System.out.println("Коллекция успешна загружена!");
            return collection;
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден или к нему нет доступа.");
        }catch (NoSuchElementException e){
            System.out.println("Информация в файле отсутствует.");
        }catch (NullPointerException e){
            System.out.println("Искомая коллекция отсутствует в файле.");
        }catch (JsonParseException e){
            System.out.println("Ошибка чтения из json. Загружаем пустую коллекцию.");
        }catch (Exception e) {
            e.printStackTrace();

        }

        return new Stack<HumanBeing>();
    }



    /**
     * Установка нового имени файла.
     * @param fileName
     */

    public void setFileName(String fileName) {
        this.filePath = fileName;
    }
}
