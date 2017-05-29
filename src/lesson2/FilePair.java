package lesson2;

class FilePair {

    private final String inputFileName;
    private final String outputFileName;

    FilePair(final String inputFileName, final String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    String getInputFileName() {

        return inputFileName;
    }

    String getOutputFileName() {

        return outputFileName;
    }
}
