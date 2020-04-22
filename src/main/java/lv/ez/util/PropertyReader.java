package lv.ez.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    Properties properties = new Properties();

    public PropertyReader() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("project.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHomeUrl() {
        return properties.getProperty("url.home");
    }

    public long getWaitTime() {
        return Long.parseLong(properties.getProperty("driver.wait.time"));
    }

    public String getSelectedDriver() {
        return properties.getProperty("driver.browser");
    }
}
