package DriverManagers;


import Enums.ExecutionType;
import Enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import  java.util.Collections;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {

    private WebDriver webDriver;
    private static BrowserType browserType;
    private static ExecutionType executionType;

    public DriverManager() {
        browserType = ConfigFileManager.getInstance().getReadConfig().getBrowser();
        executionType = ConfigFileManager.getInstance().getReadConfig().getExecutionType();
    }

    /**
     * Method to invoke the browser in local
     *
     * @return driver
     */
    public WebDriver invokeLocalDriver() {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("force-device-scale-factor=0.85");
                options.addArguments("high-dpi-support=0.85");
                options.addArguments("test-type");
                options.addArguments("--remote-allow-origins=*");
//                options.addArguments("--incognito");
                options.addArguments("start-maximized");
                options.addArguments("--ignore-certificate-errors");
//                options.addArguments("disable-infobars");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
//                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                webDriver = new EventFiringWebDriver(new ChromeDriver(options));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        long lngWaitTime = ConfigFileManager.getInstance().getReadConfig().getWaitTime();
        webDriver.manage().timeouts().implicitlyWait(lngWaitTime, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(lngWaitTime, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(lngWaitTime, TimeUnit.SECONDS);
        return webDriver;
    }

    private WebDriver invokeRemoteDriver() {
        throw new RuntimeException("Remote Driver not yet implemented");
    }

    /**
     * Method to select the type browser invoke
     *
     * @return web driver
     */
    private WebDriver invokeDriver() {
        switch (executionType) {
            case LOCAL:
                webDriver = invokeLocalDriver();
                return webDriver;
            case REMOTE:
                webDriver = invokeRemoteDriver();
                break;

        }
        return webDriver;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = invokeDriver();
        }
        return webDriver;
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}



