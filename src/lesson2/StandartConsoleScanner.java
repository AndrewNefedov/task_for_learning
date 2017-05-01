package lesson2;

import java.util.Scanner;

/**
 * Created by Andrew on 30.04.2017.
 */
public class StandartConsoleScanner {
    private String inputFileName;
    private String outputFileName;

    final Scanner scanner = new Scanner(System.in);

    public void findInputFileName(){
        System.out.println("Введите путь и имя открываемого файла");
        inputFileName = scanner.nextLine();
    }

    public String getInputFileName(){
        return inputFileName;
    }

    public void findOutputFileName(){
        System.out.println("Введите путь и имя сохраняемого файла");
        outputFileName = scanner.nextLine();
    }

    public String getOutputFileName(){
        return outputFileName;
    }
}
