package lesson2;

/**
 * Created by комп on 12.04.17.
 */

import java.io.File;
import java.util.*;
import java.lang.Exception;

public class Main
{
    public static void main(String[] args) throws Exception {
        String inputFileName;
        String outputFileName;
        if (args.length != 0){
            OptionsScanner optionsScanner = new OptionsScanner(args);
            inputFileName = optionsScanner.getInputFileName();
            outputFileName = optionsScanner.getOutputFileName();
        }

        else {
            StandartConsoleScanner standartScanner = new StandartConsoleScanner();
            standartScanner.findInputFileName();
            inputFileName = standartScanner.getInputFileName();
            standartScanner.findOutputFileName();
            outputFileName = standartScanner.getOutputFileName();
        }

        if (inputFileName.isEmpty() || outputFileName.isEmpty()){
            throw new NotFileSpecifiedException();
        }

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        if (!inputFile.exists()){
            throw new NotFileException();
        }

        FileFormat format = new FileFormat();
        format.findInputFileName(inputFileName);
        String inputFileFormat = format.getInputFileFormat();
        format.findOutputFileName(outputFileName);
        String outputFileFormat = format.getOutputFileFormat();

        ReaderRegistry readerRegistry = new ReaderRegistry();
        Reader reader = readerRegistry.getReader(inputFileFormat);

        if(reader == null){
            throw new NotFormatReadSpecifiedException();
        }

        List<PersonInformation> personRecords = new ArrayList<>();
        personRecords = reader.loadPersons(personRecords,inputFile);

        if (!personRecords.isEmpty()){
            WriterRegistry writerRegistry = new WriterRegistry();
            Writer writer = writerRegistry.getWriter(outputFileFormat);
            if (writer == null){
                throw new NotFormatWriteSpecifiedException();
            }
            writer.savePersons(personRecords,outputFile);
        }

        for (PersonInformation person : personRecords){
            System.out.print(person + "\n");
        }

    }
}