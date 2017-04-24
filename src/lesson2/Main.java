package lesson2;

/**
 * Created by комп on 12.04.17.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main
{
    public static void main (String[] args) throws Exception
    {
        final Scanner scanner = new Scanner(System.in); //создаём экземпляр класса Scanner для считывания консольного ввода
        // создаём новый ArrayList для хранения введённых пользователем данных в виде массивов PersonInformation
        final List<PersonInformation> personRecords = new ArrayList<>();
        // выводим пояснение для пользователя
        System.out.println("Введите путь к файлу, содержащий данные о людях, для заполнения");
        String route = scanner.nextLine(); // считывает введённую в консоль строку с путём до файла

        //Scanner scan = new Scanner(new File(route + args[0]));// экземпляр типа Scanner для считывания файла по пути что указал пользователь

        Scanner scan;

        if (args.length !=0)
        {
            scan = new Scanner(new File((route + args[0])));
        }
        else
        {
            System.out.println("Имя открываемого файла");
            String readNameUser = scanner.nextLine();
            System.out.println("Формат открываемого файла");
            String readExtension = scanner.nextLine();
            scan = new Scanner(new File((route + readNameUser + "."+ readExtension)));
        }

        while (scan.hasNext()) // до тех пор, пока в файле есть не прочитанные строки
        {
            String line = scan.nextLine(); // считываем строку в файле
            // разделяем введённую строку на отдельные элементы которые разделены запятой и помещаем в массив recordParts
            final String[] recordParts = line.split(",");
            /* добавляем в ArrayList новый экземпляр класса PersonInformation, представляющий собой массив в который
             передан другой массив с введёнными значениями */
            personRecords.add(new PersonInformation(recordParts));
        }
        scan.close(); // закрываем поток ввода

        System.out.println("Введите путь для сохранения файла"); //запрос для сохранения файла
        String routeWrite = scanner.nextLine(); // считываает консолный ввод пути сохранения

        //FileWriter entry = new FileWriter(new File(routeWrite + args[1])); // создание объекта для записи в файл

        FileWriter entry;

        if (args.length != 0)
        {
           entry = new FileWriter(new File((routeWrite + args[1])));
        }
        else
        {
            System.out.println("Сохранить как");
            String writeNameUser = scanner.nextLine();
            System.out.println("Формат сохраняемого файла");
            String writeExtension = scanner.nextLine();
            entry = new FileWriter(new File((routeWrite + writeNameUser + "." + writeExtension)));
        }
        if (!personRecords.isEmpty()) // если ArrayList не пустой
        {
            // объект компаратора для сортирования по имени, а если совпадают, то по фамилии
            Comparator<PersonInformation> persInfCom = new Comparation().thenComparing(new Comparation2());
            //сортировка ArrayList компаратором
            Collections.sort(personRecords, persInfCom);

            for (PersonInformation record : personRecords) // проходим по всем его элементам
            {
                System.out.println(record); // и выводим их на экран в виде, который переопределили и вернули
                entry.write(record.toString() + "\r\n"); //записываем каждый объект в файл
                //entry.append('\n');
            }
            //entry.close();
        }

        // находим максимальный возраст
        Integer maxAge = personRecords.stream().max((o1, o2) -> o1.getAge().compareTo(o2.getAge())).get().getAge();
        System.out.println("Максимальный возраст - " + maxAge);
        String ageMax = "Максимальный возраст - " + maxAge; // переменная для записи в файл
        // находим минимальный возраст
        Integer minAge = personRecords.stream().min((o1,o2) -> o1.getAge().compareTo(o2.getAge())).get().getAge();
        System.out.println("Минимальный возраст - " + minAge);
        String ageMin = "Минимальный возраст - " + minAge; // переменная для записи в файл
        // находим средний возраст
        Double srAge = personRecords.stream().mapToInt(PersonInformation :: getAge).average().getAsDouble();
        System.out.println("Средний возраст - " + srAge);
        String ageSr = "Средний возраст - " + srAge; // переменная для записи в файл
        // записываем в файл
        entry.write(ageMax + "\r\n");
        entry.write(ageMin + "\r\n");
        entry.write(ageSr + "\r\n");
        entry.close(); // закрываем поток записи
    }
}