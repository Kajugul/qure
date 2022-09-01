package pages;

import Utility.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends BaseSelenium
{
    WebDriver driver;

    @FindBy(xpath = ".//*[@href='#/login']")
    private WebElement signin;

    @FindBy(xpath = ".//*[@type='password']")
    private WebElement password;

    public SignIn(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) throws InterruptedException
    {
        waitFor(2);
        click(signin);
        sendKeys(By.xpath(".//*[@type='email']"), username);
        sendKeys(By.xpath(".//*[@type='password']"), password);
        click(By.xpath(".//*[@type='submit']"));
        waitFor(2);
    }

    public void goToGlobalFeed() throws InterruptedException
    {
        waitFor(2);
        driver.get(Constant.URL);
    }

}
