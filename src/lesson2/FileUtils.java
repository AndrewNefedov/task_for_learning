package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileUtils {

    static File getFile(final String name) throws IOException {
        return getFile(name, false);
    }

    static File getFile(final String name, final boolean createNew) throws IOException {

        if (name == null || name.isEmpty()) throw new FileNotFoundException("File " + name + " not found!");

        final File file = new File(name);

        if (createNew && !file.exists() && !file.createNewFile()) {
            throw new FileNotFoundException("Can't create a new file " + name);
        }

        if (!file.exists()) throw new FileNotFoundException("File " + name + " not found!");

        return file;
    }
}
