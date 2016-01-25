package kaart_ft.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by v.chyzhova on 24-Jan-16.
 */
public class ConfigProperties {
    private static Properties PROPERTIES;
    static {
        PROPERTIES = new Properties();
        final String configFile = System.getProperty("configFile");
        final URL props = ClassLoader.getSystemResource(configFile);
        try{
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}

