package workWithFile;

import collection.Car;
import collection.Coordinates;
import collection.HumanBeing;
import collection.Mood;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Интерфейс для работы с JSON.
 * @author Delsa
 * @version 1.0
 */

public interface ParserJSON {

    /**
     * Метод для конвертирования строки в JSON.
     * @param data - строка данных
     * @return Возвращает объект класса {@link HumanBeing#HumanBeing(String, Coordinates, Boolean, Boolean, long, String, Integer, Mood, Car)}
     */

    static HumanBeing readFromJson(String data){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(data, HumanBeing.class);
    }

    /**
     * Метод для конвертации класса
     * @param humanBeing - объект класса {@link HumanBeing#HumanBeing(String, Coordinates, Boolean, Boolean, long, String, Integer, Mood, Car)}
     * @return Возвращает JSON строку.
     */

    static String writeInJson(HumanBeing humanBeing){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(humanBeing);
    }



}
