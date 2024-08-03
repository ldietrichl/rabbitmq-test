package com.example.rabbitmq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;

    private static ConfigLoader instance;

    private ConfigLoader(String profile) {
        properties = new Properties();
        String propertiesFile = "application-" + profile + ".properties";

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find " + propertiesFile);
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load configuration from " + propertiesFile);
        }
    }

    public static ConfigLoader getInstance(String profile) {
        if (instance == null) {
            instance = new ConfigLoader(profile);
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
