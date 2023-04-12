package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginAutomationPage;

public class TC02_LoginAutomation extends Base {

    public TC02_LoginAutomation(){
        super();
    }
    LoginAutomationPage loginAutomation;
    public WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void navigateToUrl()
    {
        driver = initializeBrowserAndOpenURL(prop.getProperty("browser"));
    }

    @Test(priority = 1)
    public void verifyPageTitle()
    {
        homePage = new HomePage(driver);
        homePage.VerifyPageTitle();
    }

    @Test(priority = 2)
    public void EnterLogInDetails() throws InterruptedException {
        loginAutomation = new LoginAutomationPage(driver);
        loginAutomation.enterLogInDetails();
    }
    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
