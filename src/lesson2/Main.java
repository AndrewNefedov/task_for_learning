package lesson2;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {

        final FilePair filePair = InputDataProcessor.getFilePair(args);

        final File inputFile = FileUtils.getFile(filePair.getInputFileName());
        final File outputFile = FileUtils.getFile(filePair.getOutputFileName(), true);

        if (!inputFile.canRead()) throw new WrongAccessPermissions("Can't read input file!");
        if (!outputFile.canRead() || !outputFile.canWrite()) throw new WrongAccessPermissions("Can't read or write output file!");

        final List<PersonInformation> persons = ParserFactory.getParser(filePair.getInputFileName()).parse(inputFile);

        persons.forEach(System.out::println);

        System.out.println(); // Just new line between data

        printStatisticForAge(persons);

        ParserFactory.getSerializer(filePair.getOutputFileName()).serialize(persons, outputFile);
    }

    private static void printStatisticForAge(List<PersonInformation> persons) {

        final int[] ages = persons.stream().mapToInt(PersonInformation::getAge).toArray();
        final int sum = IntStream.of(ages).sum();
        final double average = IntStream.of(ages).average().getAsDouble();
        final int max = IntStream.of(ages).max().orElse(-1);
        final int min = IntStream.of(ages).min().orElse(-1);

        System.out.println("Age's statistic:");
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n",average);
        System.out.println("Min: " + valueOrNa(min));
        System.out.println("Max: " + valueOrNa(max));
    }

    private static String valueOrNa(int value) {
        return (value == -1) ? "N/A" : String.valueOf(value);
    }
}