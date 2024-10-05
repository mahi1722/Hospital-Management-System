package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getPropertyString(String fileName) {
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream(fileName);
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty("connectionString");
    }
}
