package lesson2;

import java.io.File;
import java.util.List;

public interface Parser {
    List<PersonInformation> parse(File input);
}
