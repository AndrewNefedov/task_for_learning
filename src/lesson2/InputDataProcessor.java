package lesson2;

import java.util.Scanner;

class InputDataProcessor {

    static FilePair getFilePair(final String[] args) {

        if (args != null && args.length > 0) {
            return ArgumentParser.getFilePair(args);
        } else {
            return ScannerParser.getFilePair();
        }
    }

    private static class ArgumentParser {

        static FilePair getFilePair(String[] args) {

            if (args.length != 2) {
                System.err.println("Params should be <input_file_name> <output_file_name>");
                throw new IllegalArgumentException("Params should be <input_file_name> <output_file_name>");
            }

            return new FilePair(args[0], args[1]);
        }
    }

    private static class ScannerParser {

        static FilePair getFilePair() {

            try (final Scanner scanner = new Scanner(System.in)) {
                System.out.print("Please type name of input file: ");
                final String inputFileName = scanner.nextLine();

                System.out.print("Please type name of output file: ");
                final String outputFileName = scanner.nextLine();

                return new FilePair(inputFileName, outputFileName);
            }
        }
    }
}
