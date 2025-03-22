package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class VtigerHomePageElements {
    @FindBy(linkText="Organizations")
    private WebElement OrganizationsLnk;

    @FindBy(linkText="Contacts")
    private WebElement ContactsLnk;

    @FindBy(linkText="Opportunities")
    private WebElement OppurtunitiesLnk;

    @FindBy(linkText="Products")
    private WebElement ProductsLnk;

    @FindBy(linkText="Leads")
    private WebElement LeadsLnk;

    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement administorImg;

    @FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath ="//a[@href='index.php?module=Users&action=Logout']")})
    private WebElement signOutLnk;
}
