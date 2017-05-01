package lesson2;

/**
 * Created by Andrew on 30.04.2017.
 */
public class OptionsScanner {
    private String inputFileName;
    private String outputFileName;

    public OptionsScanner(String[] args) {
        this.inputFileName = args[0];
        this.outputFileName = args[1];
    }

    public String getInputFileName(){
        return this.inputFileName;
    }

    public String getOutputFileName(){
        return this.outputFileName;
    }
}
