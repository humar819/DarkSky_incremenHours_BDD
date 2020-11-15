package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {  // it will connect with my config.properties, i am using this class to read any data in my config properties
    static Properties configFile;

    static {
        try {

            FileInputStream fileInputStream = new FileInputStream("config.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }


    public static String getProperty(String key){
        return configFile.getProperty(key);
    }
}

