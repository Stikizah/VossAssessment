package page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginAutomationPage extends Base {
    public WebDriver driver;

    @FindBy(linkText = "Login automation")
    private WebElement LinkLoginAutomation;

    @FindBy(css = "h2")
    private WebElement headerH2;

    @FindBy(id = "user[email]")
    private WebElement email;

    @FindBy(id = "user[password]")
    private WebElement password;

    @FindBy(xpath = "//*[@data-callback='onSubmit']")
    private WebElement onSubmit;

    @FindBy(xpath = "//*[@class='fa fa-caret-down']")
    private WebElement LogOutdrp;

    @FindBy(xpath = "//*[@id='header-dropdown-menu']/li[4]/a")
    private WebElement LogOutbtn;
    public LoginAutomationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void VerifyPageTitle()
    {
        LinkLoginAutomation.click();
        headerH2.isDisplayed();
    }

    public void enterLogInDetails() throws InterruptedException {
//        VerifyPageTitle();
        LinkLoginAutomation.click();
        headerH2.isDisplayed();
        EnterEmail();
        EnterPassword();
        ClickSubmit();
        ClickLogOut();
    }
    public void EnterEmail()
    {
        email.sendKeys(prop.getProperty("email"));
    }

    public void EnterPassword()
    {
        password.sendKeys(prop.getProperty("password"));
    }

    public void ClickSubmit()
    {
        onSubmit.click();
    }

    public void ClickLogOut() throws InterruptedException {
        WaitUntilOpenDisplayed();
        LogOutdrp.click();
        LogOutbtn.click();
    }

    public void WaitUntilOpenDisplayed() throws InterruptedException {
        Thread.sleep(2000);
    }

}
