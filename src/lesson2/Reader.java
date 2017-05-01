package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Andrew on 01.05.2017.
 */
public interface Reader {
    List<PersonInformation> loadPersons (List<PersonInformation> list,File file) throws Exception;
}

class TxtReader implements Reader{

    @Override
    public List<PersonInformation> loadPersons(List<PersonInformation> list,File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file); // считываем файл по указанному в параметре пути
        while (scan.hasNext()) // до тех пор, пока в файле есть не прочитанные строки
        {
            String line = scan.nextLine();// считываем строку в файле
            // разделяем введённую строку на отдельные элементы которые разделены запятой и помещаем в массив recordParts
            final String[] recordParts = line.split(",");
            /* добавляем в ArrayList новый экземпляр класса PersonInformation, представляющий собой массив в который
             передан другой массив с введёнными значениями */
           list.add(new PersonInformation(recordParts));
        }
        scan.close(); // закрываем поток ввода
        return list;
    }
}
