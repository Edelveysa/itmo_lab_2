package workWithFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс FileManager, отвечающий за работу с файлом.
 * @author Delsa
 * @version 1.0
 */

public class FileManager {
    /** Поле файл */
    private File file;

    public FileManager() {
        this.file = new File(System.getenv("LAB"));
    }

    /**
     * Функция записи в файл{@link FileManager#file}
     * @param data - данные для записи в файл.
     */

    private void writeInFile(String data){
        FileWriter writer = null;
        try{
            writer = new FileWriter(file);
            writer.write(data);
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

    private String readFromFile(){
        List<String> data = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return data.toString();
    }


}
