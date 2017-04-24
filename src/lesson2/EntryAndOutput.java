package lesson2;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by Andrew on 24.04.2017.
 */
public class EntryAndOutput //КЛАСС ДЛЯ СОХРАНЕНИЯ ДАННЫХ И ВЫВОДА НА КОНСОЛЬ
{

    public void writeFile(File pathSavedFile, List<PersonInformation> personRecords,String[] dataOnAge) throws Exception // МЕТОД ДЛЯ СОХРАНЕНИЯ
    {
        FileWriter entry = new FileWriter(pathSavedFile); // записывает в файл по переданному в параметре пути
        for (PersonInformation record : personRecords) // проходим по всем элементам списка
        {
            entry.write(record.toString() + "\r\n"); //записываем каждый объект в файл
        }
        for(String interestedAge : dataOnAge) //проходим по всем элементам массива с возрастом
        {
            entry.write(interestedAge + "\r\n"); //записываем каждый элемент в файл
        }
        entry.close(); //закрываем поток записи
    }

    public void outputData(List<PersonInformation> personRecords,String[] dataOnAge) // МЕТОД ДЛЯ ВЫВОДА НА КОНСОЛЬ
    {
        for (PersonInformation record : personRecords) // проходим по всем элементам списка
        {
            System.out.println(record.toString()); //выводим каждый объект в консоль
        }
        for(String interestedAge : dataOnAge) //проходим по всем элементам массива с возрастом
        {
            System.out.println(interestedAge); //выводим каждый элемент на консоль
        }
    }
}
