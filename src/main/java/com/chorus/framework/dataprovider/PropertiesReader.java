package com.chorus.framework.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author p.a.kumar.banerjee
 */

public class PropertiesReader {

    private final String propertiesfilepath = System.getProperty("user.dir")+"\\src\\main\\resources\\config\\Config.properties";
    private Properties environmentparameters;
    
    /**
     * Read values from properties file (EnvironmentParameters.properties)
     * 
     * @param key
     * @return String
     * @throws IOException
     */

    public PropertiesReader() {

        environmentparameters = new Properties();
        try
        {
            FileInputStream filepath = new FileInputStream
                (new File(propertiesfilepath));
            environmentparameters.load(filepath);
            filepath.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getApplicationURL() {

        String applicationURL = environmentparameters.getProperty("URL");
        return applicationURL;
    }

    public long getExplicitlyWait() {

        String explicitlyWait = environmentparameters.getProperty("ExplicitlyWait");
        return Long.parseLong(explicitlyWait);
    }

    public String getBrowserType() {

        String browserType = environmentparameters.getProperty("BrowserType");
        return browserType;
    }

    public String getPassword() {
        
        String password = environmentparameters.getProperty("Pwd");
        return password;
    }
}