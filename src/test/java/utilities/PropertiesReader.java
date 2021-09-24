package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {

    Properties properties = null;

    String defaultFilepath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

    public PropertiesReader() {

        final String environment = System.getProperty("ENVIRONMENT");
        final String filepathFromEnv = System.getProperty("user.dir") + "/src/test/resources/config." + environment + ".properties";

        try {

            properties = new Properties();
            properties.load(new FileInputStream(defaultFilepath));

            final Path path = Paths.get(filepathFromEnv);
            if (Files.exists(path)) {
                properties.load(new FileInputStream(filepathFromEnv));
            }

        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public String getPropValue(String keyvalue) {
        return properties.getProperty(keyvalue);
    }

}
