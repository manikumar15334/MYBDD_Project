package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VtigerLoginPageElements {
    @FindBy(name = "user_name")
    private WebElement	userNameEdt;

    @FindBy(name = "user_password")
    private WebElement	passwordEdt;

    @FindBy(id ="submitButton")
    private WebElement loginBtn;

}
