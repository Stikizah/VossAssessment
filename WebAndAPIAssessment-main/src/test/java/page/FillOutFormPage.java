package page;

import base.Base;
import org.codehaus.groovy.ast.stmt.DoWhileStatement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillOutFormPage extends Base {
    public WebDriver driver;

    @FindBy(linkText = "Fill out forms")
    private static WebElement FillOutFormsLnk;

    @FindBy(id = "et_pb_contact_name_0")
    private static WebElement NameOne;

    @FindBy(id = "et_pb_contact_message_0")
    private static WebElement MassageOne;

    @FindBy(xpath = "//*[@id='et_pb_contact_form_0']/div[2]/form/div/button")
    private static WebElement btnSubmit;

    @FindBy(id = "et_pb_contact_name_1")
    private static WebElement NameTwo;

    @FindBy(id = "et_pb_contact_message_1")
    private static WebElement MassageTwo;

    @FindBy(xpath = "//*[@id='et_pb_contact_form_1']/div[2]/form/div/button")
    private static WebElement btnSubmitTwo;

    @FindBy(xpath = "//*[@id='et_pb_contact_form_0']/div/p")
    private static WebElement ContactingUs;

    @FindBy(xpath = "//*[@id='et_pb_contact_form_1']/div/p")
    private static WebElement ContactingUsTwo;

    //*[@id="et_pb_contact_form_1"]/div/p
    @FindBy(xpath = "//*[@class='et_pb_contact_captcha_question']")
    private static WebElement txtNumber;

    @FindBy(xpath = "//*[@name='et_pb_contact_captcha_1']")
    private static WebElement txtTotalNumber;

      public FillOutFormPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static void AddUsersWithTheFollowingDetails(String strNameOne, String strMassageOne, String strNameTwo, String strMassageTwo, String strMsgDisplayed) throws InterruptedException {
//        enterLogInDetails();
        FillOutFormsLnk.click();
        NameOne.sendKeys(strNameOne);
        MassageOne.sendKeys(strMassageOne);
        btnSubmit.click();

        verifyContactDisplayed(strMsgDisplayed);

        NameTwo.sendKeys(strNameTwo);
        MassageTwo.sendKeys(strMassageTwo);

        EnterAndCalculate();
        btnSubmitTwo.click();

        WaitUntilOpenDisplayed();

//        verifyContactDisplayedTwo(strMsgDisplayed);


    }
    public static void verifyContactDisplayed(String msgDisplayed) throws InterruptedException {
        msgDisplayed = ContactingUs.getText();

        int i=1;

        do{
            btnSubmit.click();
            WaitUntilOpenDisplayed();

            System.out.println("Error........");

            System.out.println(i);
            i++;
        }while(msgDisplayed.equalsIgnoreCase("Thanks for contacting us"));
            System.out.println("Thanks for contacting us");

    }

    public static void verifyContactDisplayedTwo(String msgDisplayed) throws InterruptedException {


    }
    public static void EnterAndCalculate()
    {
        String num1 = txtNumber.getText();

        int sum = 0;

        for(int i=0;i<num1.length();i++)
        {
            System.out.println("Total is:"+sum++);
        }

        int One = Integer.parseInt(num1.substring(0,2).trim());
        int Two = Integer.parseInt(num1.substring(4,sum).trim());

        int iTest = Integer.parseInt(String.valueOf(One + Two));

        System.out.println("Arithmetic Operation on Int: " + iTest);

        String total = String.valueOf(iTest);
        txtTotalNumber.sendKeys(total);

    }
    public static void WaitUntilOpenDisplayed() throws InterruptedException {
        Thread.sleep(2000);
    }
}
