package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    //private final String propertyFilePath = "src/test/java/Config/Configuration_e1.properties";
    private String environment = System.getProperty("env");



    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath;
       //System.out.println("Environment is "+environment);
       if(environment.equalsIgnoreCase("e1"))
       {
           System.out.println("Environment is "+environment);
           propertyFilePath = "src/test/java/Config/Configuration_e1.properties";
       }
       else if(environment.equalsIgnoreCase("e2")){
           System.out.println("Environment is "+environment);
           propertyFilePath = "src/test/java/Config/Configuration_e2.properties";
       }
       else{
           System.out.println("Environment is "+environment);
           propertyFilePath = "src/test/java/Config/Configuration_e1.properties";
       }
        
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
        Systen.out.println("URL is "+ url);
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
