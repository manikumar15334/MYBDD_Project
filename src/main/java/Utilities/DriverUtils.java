package Utilities;

import DriverManagers.DriverManager;
import Pages.BasePage;

public class DriverUtils {
    private final  DriverManager driverManager;
    private final BasePage basePage;
    public ScenarioContext  scenariContext;

    public DriverUtils(DriverManager driverManager, BasePage basePage) {
        this.driverManager = driverManager;
        this.basePage = basePage;
        scenariContext = new ScenarioContext();
    }

    public DriverManager getDriverManager(){
        return driverManager;
    }

    public BasePage getBasePage(){
        return basePage;
    }
    public ScenarioContext getScenariContext(){
        return scenariContext;
    }
}
