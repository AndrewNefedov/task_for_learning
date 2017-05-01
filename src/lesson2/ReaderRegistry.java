package lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 01.05.2017.
 */
public class ReaderRegistry {

    private Map<String, Reader> registry = new HashMap<>();

    {
        registry.put("txt", new TxtReader());
    }

    public Reader getReader(String inputFileFormat){
        return registry.get(inputFileFormat);
    }
}
