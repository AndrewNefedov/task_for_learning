package lesson2;

import java.util.stream.Stream;

/**
 * Created by Andrew on 30.04.2017.
 */
public class FileFormat {

    private String inputFileFormat;
    private String outputFileFormat;

    public void findInputFileName (String inputFileName){
        String openFileName = inputFileName;
        String[] dividedInputFileName = openFileName.split("[.\\s]");
        inputFileFormat = dividedInputFileName[dividedInputFileName.length - 1];
    }

    public String getInputFileFormat(){
        return inputFileFormat;
    }

    public void findOutputFileName (String outputFileName){
        String saveFileName = outputFileName;
        String[] dividedOutputFileName = saveFileName.split("[.\\s]");
        outputFileFormat = dividedOutputFileName[dividedOutputFileName.length - 1];
    }

    public String getOutputFileFormat(){
        return outputFileFormat;
    }
}
