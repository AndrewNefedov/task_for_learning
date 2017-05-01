package lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 01.05.2017.
 */
public class WriterRegistry {

    private Map<String, Writer> saveRegistry = new HashMap<>();

    {
        saveRegistry.put("txt", new TxtWriter());
    }

    public Writer getWriter(String outputFileFormat){
        return saveRegistry.get(outputFileFormat);
    }
}
