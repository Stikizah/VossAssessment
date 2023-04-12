package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.FillOutFormPage;
import page.HomePage;
import page.LoginAutomationPage;

public class TC03_FillOutForm extends Base {
    public WebDriver driver;
    WebDriverWait waitElementToDisplay;
    HomePage homePage;
    FillOutFormPage addUserPage;

    public TC03_FillOutForm(){
        super();
    }
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

    @Test(priority = 2, dataProvider = "testData")
    public void fillOutFormPage(String strNameOne, String strMassageOne, String strNameTwo, String strMassageTwo, String strMsgDisplayed) throws InterruptedException {
        addUserPage = new FillOutFormPage(driver);
        FillOutFormPage.AddUsersWithTheFollowingDetails(strNameOne, strMassageOne, strNameTwo, strMassageTwo, strMsgDisplayed);

  }

    @DataProvider
    public Object[][] testData()
    {
        Object[][] data = utilities.getTestData.getTestDataFromExcel("Sheet1");
        return data;
    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
