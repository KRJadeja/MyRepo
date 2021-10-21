package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/java/Config/Configuration_e1.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration_e1.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration_e1.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration_e1.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        String pwd = getViewerPassword();
        pwd=pwd.replace("@","%40");
        pwd=pwd.replace("$","%24");
        String credentials = getViewerUserName()+":"+pwd;
        url= url.replace("https://","https://"+credentials+"@");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration_e1.properties file.");
    }
    public String getViewerUserName()
    {
        String UserName = properties.getProperty("ViewerUserName");

        if (UserName != null) return UserName;
        else throw new RuntimeException("UserName not specified in the Configuration_e1.properties file.");
    }
    public String getViewerPassword()
    {
        String Password = properties.getProperty("ViewerPassword");
        if (Password != null) return Password;
        else throw new RuntimeException("Password not specified in the Configuration_e1.properties file.");
    }
}