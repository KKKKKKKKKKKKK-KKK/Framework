package service;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;


public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("qa");//System.getProperty("environment"));

    public static String getTestData(String key){
        String notUtf8 =resourceBundle.getString(key);
        byte[] bytes = notUtf8.getBytes(StandardCharsets.UTF_8);

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
