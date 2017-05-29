package lesson2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvPerson implements Parser, Serializer {

    @Override
    public void serialize(List<PersonInformation> persons, File outputFile) {

        if (persons.isEmpty()) return;

        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            persons.stream()
                    .map(this::personToCsv)
                    .forEach(csvPerson -> {
                        try {
                            writer.write(csvPerson);
                            writer.newLine();
                        } catch (IOException e) {
                            System.err.println("Can't write a line: " + csvPerson);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PersonInformation> parse(File inputFile) {

        try (final BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            return reader.lines()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(","))
                    .map(PersonInformation::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String personToCsv(PersonInformation person) {

        final List<String> parts = Arrays.asList(
                person.getFirstName(),
                person.getLastName(),
                String.valueOf(person.getAge()),
                person.getEmail());
        return String.join(",", parts);
    }
}
