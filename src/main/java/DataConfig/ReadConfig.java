package DataConfig;

import Enums.ExecutionType;
import Enums.BrowserType;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    private final Properties properties;

    /**
     * Method to read config file values
     */
    public ReadConfig() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String strPropertyPath = "config/configruation.properties";
        try {
            fileReader = new FileReader(strPropertyPath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config file not found at " + strPropertyPath);
        }
    }

    /**
     * Method to get the application url value from the property file
     *
     * @return application url
     */
    public String getApplicationURL() {
        String strAppURL = properties.getProperty("Environment");
        strAppURL = "http://" + strAppURL + "localhost:8888/";
        if (strAppURL != null) {
            return strAppURL;
        } else {
            throw new RuntimeException("Application URL is not present in the config property");
        }
    }

    /**
     * Method to get the application url value from the property file
     *
     * @return application url
     */
    public String getUserName() {
        String strUserName = properties.getProperty("Username");
        if (strUserName != null) {
            return strUserName;
        } else {
            throw new RuntimeException("Username is not present in the config property");
        }
    }

    /**
     * Method to get the application url value from the property file
     *
     * @return application url
     */
    public String getPassword() {
        String strPassword = properties.getProperty("Username");
        if (strPassword != null) {
            return strPassword;
        } else {
            throw new RuntimeException("Password is not present in the config property");
        }
    }

    /**
     * Method to get the wait time value from the property file
     *
     * @return wait time
     */
    public long getWaitTime() {
        String strWaitTime = properties.getProperty("WaitTime");
        if (strWaitTime != null) {
            return Long.parseLong(strWaitTime);
        } else {
            throw new RuntimeException("Wait Time is not present in the config property");
        }
    }

    /**
     * Method to get the browser value from the property file
     *
     * @return type of browser
     */
    public BrowserType getBrowser() {
        String strBrowser = properties.getProperty("Browser");
        switch (strBrowser) {
            case "chrome":
                return BrowserType.CHROME;
            case "firefox":
                return BrowserType.FIREFOX;
            case "edge":
                return BrowserType.EDGE;
            case "safari":
                return BrowserType.SAFARI;
            default:
            throw new RuntimeException("Browser is not present in the config property");
        }
    }

    /**
     * Method to get the execution type value from the property file
     *
     * @return type of browser
     */
    public ExecutionType getExecutionType() {
        String strExecutionType = properties.getProperty("ExecutionType");
        switch (strExecutionType) {
            case "local":
                return ExecutionType.LOCAL;
            case "remote":
                return ExecutionType.REMOTE;
                default:
                throw new RuntimeException("ExecutionType is not present in the config property");
        }
    }
}
