package page;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static page.FillOutFormPage.WaitUntilOpenDisplayed;

public class FakePricingPage extends Base {
    public WebDriver driver;

    @FindBy(linkText = "Fake Pricing Page")
    private WebElement btnFakePricingPage;

    @FindBy(xpath = "//*[@id='post-5050']/div/div[1]//div[2]/div[2]//div/div[4]/a")
    private WebElement btnFakePricing;
    String responseBody;
    int statusCode;
    public FakePricingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Purchase() throws InterruptedException {
        WaitUntilOpenDisplayed();
        btnFakePricingPage.click();
        WaitUntilOpenDisplayed();
        btnFakePricing.click();
    }
    public void fake_Pricing_Page() throws InterruptedException {
        Purchase();
    }

}
