package it.thinkopen.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static final Properties properties = new Properties();

    public static Properties getConfig() {
        try {
            properties.load(new FileReader("C:/Users/Niccolo/IdeaProjects/WebAppCovid/src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

}
