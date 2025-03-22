package DriverManagers;

import DataConfig.ReadConfig;

public class ConfigFileManager {
    private static final ConfigFileManager configFileManager = new ConfigFileManager();
    private static ReadConfig readconfig;
    private ConfigFileManager(){}
    public static ConfigFileManager getInstance(){
        return configFileManager;
    }

    /**
     * Method to create object for read config
     * @return read config object
     */
    public ReadConfig getReadConfig(){
        return (readconfig == null) ? new ReadConfig() : readconfig;}

}


