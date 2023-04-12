package page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public WebDriver driver;
    @FindBy(xpath = "//*[@class='btn btn-link pull-right']")
    private WebElement verifyUserList;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void VerifyPageTitle()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Practice - Ultimate QA";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
    }
}
