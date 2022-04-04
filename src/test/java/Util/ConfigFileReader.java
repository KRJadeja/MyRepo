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

   public String getApplicationUrl() {
        String url = properties.getProperty("url");
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

    public String getSubmitterUserName() {
        String UserName = properties.getProperty("SubmiterUserName");

        if (UserName != null) return UserName;
        else throw new RuntimeException("UserName not specified in the Configuration_e1.properties file.");
    }

    public String getSubmitterPassword() {
        String Password = properties.getProperty("SubmiterPassword");
        if (Password != null) return Password;
        else throw new RuntimeException("Password not specified in the Configuration_e1.properties file.");
    }

    public String getApproverUserName() {
        String UserName = properties.getProperty("ApproverUserName");

        if (UserName != null) return UserName;
        else throw new RuntimeException("UserName not specified in the Configuration_e1.properties file.");
    }

    public String getApproverPassword() {
        String Password = properties.getProperty("ApproverPassword");
        if (Password != null) return Password;
        else throw new RuntimeException("Password not specified in the Configuration_e1.properties file.");
    }
}