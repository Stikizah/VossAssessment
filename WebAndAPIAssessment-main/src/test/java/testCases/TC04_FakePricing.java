package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.FakePricingPage;
import page.FillOutFormPage;
import page.HomePage;
import page.LoginAutomationPage;


public class TC04_FakePricing extends Base {

    HomePage homePage;
    FillOutFormPage addUserPage;

    public TC04_FakePricing(){
        super();
    }
    public WebDriver driver;

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
    public void FakePricingPage() throws InterruptedException {
        FakePricingPage fakePricingPage = new FakePricingPage(driver);
        fakePricingPage.fake_Pricing_Page();
    }


}
