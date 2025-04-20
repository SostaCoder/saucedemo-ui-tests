package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Load the config file only once
    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    // Method to get any property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

