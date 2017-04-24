package lesson2;

/**
 * Created by комп on 12.04.17.
 */

import java.io.File;
import java.util.*;

public class Main
{
    public static void main (String[] args) throws Exception
    {
        ScanPath pathOfFile = new ScanPath(); //экземпляр для доступа к методам по выяснению пути к файлам
        File readPath = pathOfFile.pathReader(args); //передаём массив в метод и сохраняем путь к считываемому файла
        listWork sortList = new listWork(); //экземпляр для доступа к методам сортировки списка
        sortList.readFile(readPath); // передаём путь к считываемму файлу и считываем файл, заполняя список
        List sortedList = sortList.listSort(); //сортируем список и сохраняем его
        String[] dataOnAge = sortList.listAge(); //сохраняем массив, содержащий данные о макс, мин и ср. возрасте
        File pathSavedFile = pathOfFile.pathWriter(args); //передаём массив в метод и сохраняем путь к сохраняемому файлу
        EntryAndOutput saveFile = new EntryAndOutput(); // экземпляр для сохранения файла и вывода на консоль
        saveFile.writeFile(pathSavedFile,sortedList,dataOnAge); //сохраняем в файл
        saveFile.outputData(sortedList,dataOnAge); //выводим на консоль
    }
}