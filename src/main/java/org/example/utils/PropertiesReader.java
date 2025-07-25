package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key) {

            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Navaneeth H K\\IdeaProjects\\Naukari\\src\\main\\resources\\data.properties");
                Properties p = new Properties();
                p.load(fileInputStream);
                return p.getProperty(key);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
