package lesson2;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by Andrew on 01.05.2017.
 */
public interface Writer {
    void savePersons (List<PersonInformation> list, File file) throws Exception;
}

class TxtWriter implements Writer{

    @Override
    public void savePersons(List<PersonInformation> list, File file) throws Exception {
        FileWriter entry = new FileWriter(file); // записывает в файл по переданному в параметре пути
        for (PersonInformation record : list) // проходим по всем элементам списка
        {
            entry.write(record.toString() + "\r\n"); //записываем каждый объект в файл
        }
        entry.close();
    }
}
