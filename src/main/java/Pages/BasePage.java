package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver webDriver;
     private VtigerLoginPage vtigerLoginPage;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public VtigerLoginPage getVtigerLoginPage(){
        return (vtigerLoginPage==null) ? vtigerLoginPage=new VtigerLoginPage(webDriver):vtigerLoginPage;
    }


}
