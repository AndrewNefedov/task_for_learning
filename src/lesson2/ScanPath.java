package lesson2;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Andrew on 24.04.2017.
 */

public class ScanPath //КЛАСС ДЛЯ ПУТЕЙ К СЧИТЫВАЕМОМУ И СОХРАНЯЕМОМУ ФАЙЛАМ
{
    final Scanner scanner = new Scanner(System.in); //создаём экземпляр класса Scanner для считывания консольного ввода
    private File pathRead;
    private File pathWrite;

    public File pathReader(String[] args) //МЕТОД ДЛЯ ОПРЕДЕЛЕНИЯ ПУТИ ДЛЯ ЧТЕНИЯ ФАЙЛА
    {
        System.out.println("Введите путь к файлу, содержащий данные о людях");
        String route = scanner.nextLine(); // считывает введённую в консоль строку с путём до файла


        if (args.length != 0) // если в метод main были переданы параметры
        {
            pathRead = new  File((route + args[0])); // то берём первый элемент
        }
        else // в противном случае
        {
            System.out.println("Имя открываемого файла"); //узнаём имя
            String readNameUser = scanner.nextLine(); // считываем и сохраняем введённое имя
            System.out.println("Формат открываемого файла"); //узнаём формат
            String readExtension = scanner.nextLine(); //считываем и сохраняем формат
            pathRead = new File((route + readNameUser + "." + readExtension)); // указываем путь к файлу
        }
        return pathRead;// возвращаем путь к считываемому файлу
    }


    public File pathWriter(String[] args)  //МЕТОД ДЛЯ ОПРЕДЕЛЕНИЯ ПУТИ ДЛЯ СЩХРАНЕНИЯ ФАЙЛА
    {
        System.out.println("Введите путь для сохранения файла"); //запрос для сохранения файла
        String routeWrite = scanner.nextLine(); // считываает консолный ввод пути сохранения

        if (args.length != 0)// если в метод main были переданы параметры
        {
            pathWrite = new File((routeWrite + args[1]));// то берём второй элемент
        }
        else // в противном случае
        {
            System.out.println("Сохранить как"); //узнаём имя
            String writeNameUser = scanner.nextLine(); // считываем и сохраняем введённое имя
            System.out.println("Формат сохраняемого файла"); //узнаём формат
            String writeExtension = scanner.nextLine(); //считываем и сохраняем формат
            pathWrite = new File((routeWrite + writeNameUser + "." + writeExtension)); // указываем путь к файлу
        }
        return pathWrite; // возвращаем путь к сохраняемому файлу
    }
}