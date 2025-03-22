package Utilities;

import DriverManagers.LoggerManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ReusableUtils {
    private final WebDriver webDriver;

    Logger log= LoggerManager.getLogger(ReusableUtils.class);

    public ReusableUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Method to load the given Url in browser tab
     * @param strURL-URL to be load on browser
     */
    public void gotoURL(String strURL){
        webDriver.get(strURL);
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        log.info(strURL+"URL loaded on the browser");
    }



    /**
     * This method will wait for particular element to be clickable
     * @param driver
     * @param element
     */
    public void waitForElementToBeClickable(WebDriver driver,WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will wait for particular element to perform click operation
     * if the element is not iterative
     * @param element
     * @throws InterruptedException
     */
    public void customWaitAndClickonElement(WebElement element) throws InterruptedException
    {
        int count=0;
        while(count<10)
        {
            try {
                element.click();
                break;
            }
            catch(Exception e) {
                //TODO:handle exception
                Thread.sleep(1000);
                count++;
            }
        }
    }


    /**
     * This method will handle drop down by select class using index
     * @param element
     * @param index
     */
    public void handleDropDown(WebElement element,int index)
    {
        Select s=new Select(element);
        s.selectByIndex(index);
    }


    /**
     * This method will handle the drop down by select class using visible text
     * @param element
     * @param visibleText
     */
    public void handleDropDown(WebElement element,String visibleText)
    {
        Select s=new Select(element);
        s.selectByVisibleText(visibleText);
    }


    /**
     * This method will handle the drop down by select class using value
     * @param value
     * @param element
     */
    public void handleDropDown( String value,WebElement element)
    {
        Select s=new Select(element);
        s.selectByValue(value);
    }


    /**
     * This method will perform double click over a page
     * @param driver
     */
    public void doubleClickOn(WebDriver driver)
    {
        Actions act=new Actions(driver);
        act.doubleClick().perform();
    }


    /**
     * This method will perform double click over a particular element
     * @param driver
     * @param element
     */

    public void doubleClickOn(WebDriver driver, WebElement element)
    {
        Actions act=new Actions(driver);
        act.doubleClick(element).perform();
    }


    /**
     * this method will perform mouse hover action on a particular element
     * @param driver
     * @param element
     */
    public void mouseHoverOn(WebDriver driver, WebElement element)
    {
        Actions act=new Actions(driver);
        act.moveToElement(element).perform();
    }


    /**
     * this method will perform mouse hover action over the offset
     * @param driver
     * @param x
     * @param y
     */
    public void mouseHoverOn(WebDriver driver, int x,int y)
    {
        Actions act=new Actions(driver);
        act.moveByOffset(x,y).perform();
    }


    /**
     * This method will perform right click on the page
     * @param driver
     */
    public void rightClickOn(WebDriver driver)
    {
        Actions act=new Actions(driver);
        act.contextClick().perform();
    }


    /**
     * This method will perform right click on the particular element
     * @param driver
     * @param element
     */
    public void rightClickOn(WebDriver driver, WebElement element)
    {
        Actions act=new Actions(driver);
        act.contextClick(element).perform();
    }


    /**
     * This method will perform drag and drop action from src element to target element
     * @param driver
     * @param srcElement
     * @param targetElement
     */
    public void dragAndDropOn(WebDriver driver, WebElement srcElement, WebElement targetElement)
    {
        Actions act=new Actions(driver);
        act.dragAndDrop(srcElement, targetElement).perform();
    }


    /**
     * This method will accept the alert popup
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }


    /**
     * this method will dismiss the popup
     * @param driver
     */
    public void dismissAlert(WebDriver driver)
    {
        driver.switchTo().alert().dismiss();
    }


    /**
     * This method will get the text from alert popup and return it to caller
     * @param driver
     * @return
     */
    public String getTextInAlert(WebDriver driver)
    {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }


    /**
     * This method will  switch to the window with respect to the window title
     * @param driver
     * @param partialTitle
     */
    public void switchToWindow(WebDriver driver, CharSequence partialTitle)
    {
        //step 1:get all window handles
        Set<String> windowsIds = driver.getWindowHandles();

        //step 2:iterate thru all the windows
        Iterator<String> it = windowsIds.iterator();

//step 3:navigate inside the windows
        while(it.hasNext())
        {
            //capture all the window ids
            String winId = it.next();

            //switch to the window and capture the title
            String currentTitle = driver.switchTo().window(winId).getTitle();
            if(currentTitle.contains(partialTitle))
            {
                break;
            }
        }
    }


    /**
     * switch to the frame based on index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver,int index)
    {
        driver.switchTo().frame(index);
    }


    /**
     * switch to frame based on name or id
     * @param driver
     * @param idOrName
     *
     */
    public void switchToFrame(WebDriver driver, String idOrName)
    {
        driver.switchTo().frame(idOrName);
    }


    /**
     * switch to frame based on frame element
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver,  WebElement element)
    {
        driver.switchTo().frame(element);
    }


    /**
     * This method will take screen shot and return to the destination path
     * @param driver
     * @param screenShotName
     * @return
     * @throws IOException
     */
    public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path =".\\ScreenShots\\"+screenShotName+".png";
        File dst =new File(path);
        FileUtils.copyFile(src,dst);

        return dst.getAbsolutePath();//used for reporting in listeners

    }


    /**
     * this method will perform random scroll
     * @param driver
     */
    public void scrollAction(WebDriver driver)
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)","");
    }


    /**
     * this method will scroll until the particular element
     * @param driver
     * @param element
     */
    public void scrollAction(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //js.executeScript("argument[0].scrollIntoView()",element);
        int y=element.getLocation().getY();
        js.executeScript("window.scrollBy(0,"+y+")",element);

    }
}
