package lesson2;

import java.util.HashMap;
import java.util.Map;

class ParserFactory {

    private static Map<String, Parser> parsers = new HashMap<>();
    private static Map<String, Serializer> serializers = new HashMap<>();

    static {
        parsers.put("xml", new XmlPerson());
        parsers.put("csv", new CsvPerson());

        serializers.put("xml", new XmlPerson());
        serializers.put("csv", new CsvPerson());
    }

    static Parser getParser(String fileName) {
        return parsers.entrySet().stream()
                .filter(entry-> fileName.endsWith(entry.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new NotRegisteredParser("Parser for file " + fileName + " wasn't found."));
    }

    static Serializer getSerializer(String fileName) {
        return serializers.entrySet().stream()
                .filter(entry-> fileName.endsWith(entry.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new NotRegisteredSerializer("Serializer for file " + fileName + " wasn't found."));
    }
}
