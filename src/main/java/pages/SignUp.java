package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends BaseSelenium
{
    WebDriver driver;
    @FindBy(xpath = ".//*[contains(text(),'Sign up')]")
    private WebElement signUp;

    public SignUp(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DashBoard doSignUp(String username, String password, String email) throws InterruptedException
    {
        click(signUp);
        sendKeys(By.xpath(".//*[@placeholder='Username']"), username);
        sendKeys(By.xpath(".//*[@placeholder='Email']"), email);
        sendKeys(By.xpath(".//*[@placeholder='Password']"), password);
        click(By.xpath(".//*[@type='submit']"));
        waitFor(2);
        return PageFactory.initElements(driver, DashBoard.class);
    }

    public void signOut()  throws  InterruptedException
    {
        click(By.xpath(".//*[@href='#/settings']"));
        scrollDown();
        click(By.xpath(".//*[@ng-click='$ctrl.logout()']"));
    }
}
