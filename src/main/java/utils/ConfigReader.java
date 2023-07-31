package utils;


import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class ConfigReader {

    public static Configuration getConfiguration() {
        try {
            return new Configurations().properties(new File("configuration.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
