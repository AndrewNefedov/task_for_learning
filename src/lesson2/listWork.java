package lesson2;

import java.io.File;
import java.util.*;

/**
 * Created by Andrew on 24.04.2017.
 */
public class listWork //КЛАСС ДЛЯ ОБРАБОТКИ ДАННЫХ
{
    // создаём новый ArrayList для хранения введённых пользователем данных в виде массивов PersonInformation
    public List<PersonInformation> personRecords = new ArrayList<>();

    public List readFile(File readPath) throws Exception // МЕТОД ДЛЯ ДОБАВЛЕНИЯ ДАННЫХ В ArrayList
    {
        Scanner scan = new Scanner( readPath); // считываем файл по указанному в параметре пути
        while (scan.hasNext()) // до тех пор, пока в файле есть не прочитанные строки
        {
            String line = scan.nextLine();// считываем строку в файле
            // разделяем введённую строку на отдельные элементы которые разделены запятой и помещаем в массив recordParts
            final String[] recordParts = line.split(",");
            /* добавляем в ArrayList новый экземпляр класса PersonInformation, представляющий собой массив в который
             передан другой массив с введёнными значениями */
            personRecords.add(new PersonInformation(recordParts));
        }
        scan.close(); // закрываем поток ввода
        return personRecords; //возвращаем ArrayList
    }

    public List listSort() //МЕТОД ДЛЯ СОРТИРОВКИ СПИСКА
    {
        if (!personRecords.isEmpty()) // если ArrayList не пустой
        {
            // объект компаратора для сортирования по имени, а если совпадают, то по фамилии
            Comparator<PersonInformation> persInfCom = new Comparation().thenComparing(new Comparation2());
            //сортировка ArrayList компаратором
            Collections.sort(personRecords, persInfCom);
        }
        return personRecords; // возвращаем отсортированный список
    }

    public String[] listAge() //МЕТОД ДЛЯ НАХОЖДЕНИЯ МИН,МАКС, и СР. ВОЗРАСТА
    {
        // находим максимальный возраст
        Integer maxAge = personRecords.stream().max((o1, o2) -> o1.getAge().compareTo(o2.getAge())).get().getAge();
        // находим минимальный возраст
        Integer minAge = personRecords.stream().min((o1,o2) -> o1.getAge().compareTo(o2.getAge())).get().getAge();
        // находим средний возраст
        Double srAge = personRecords.stream().mapToInt(PersonInformation :: getAge).average().getAsDouble();
        String maxAgeLine = "Максимальный возраст: " + String.valueOf(maxAge); //переводим максимальный возраст в строку
        String minAgeLine = "Минимальный возраст: " + String.valueOf(minAge); //переводим минимальный возраст в строку
        String srAgeLine = "Средний возраст: " + String.valueOf(srAge); //переводим средний возраст в строку
        String[] age1 = {maxAgeLine,minAgeLine,srAgeLine}; // создаём массив для возврата этих значений
        return age1; //возвращаем массив вызываемому этот метод объекту
    }
}
