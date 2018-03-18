package application;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    private String name;
    private File file;

    public FileEventLogger(String name) {
        this.name = name;
    }


    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   // @PostConstruct
    public void init() throws IOException {

        this.file = new File(name);

        if (!file.exists()) {
            file.createNewFile();
        }

        if (!file.canWrite()) {
            throw new RuntimeException();
        }

    }


}
