package projectManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Properties properties = new Properties();
    private static final String propertyFilePath = "src/test/resources/config.properties";

    private PropertyManager() {
        loadProperties();
    }

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (PropertyManager.class) {
                if (instance == null) {
                    instance = new PropertyManager();
                }
            }
        }
        return instance;
    }

    private void loadProperties() {
        try (InputStream input = new FileInputStream(propertyFilePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file: " + propertyFilePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

