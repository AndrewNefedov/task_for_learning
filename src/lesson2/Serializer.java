package lesson2;

import java.io.File;
import java.util.List;

public interface Serializer {
    void serialize(List<PersonInformation> persons, File outputFile);
}
