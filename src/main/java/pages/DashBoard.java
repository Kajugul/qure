package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoard
{
    private WebDriver driver;

    public DashBoard(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private SignUp signUp;
    private SignIn signIn;
    private NewArticle newArticle;

    public SignUp getSignUp()
    {
        return (signUp == null) ? signUp = new SignUp(this.driver) : signUp;
    }

    public SignIn getSign()
    {
        return (signIn == null) ? signIn = new SignIn(this.driver) : signIn;
    }

    public NewArticle getNewArticle()
    {
        return (newArticle == null) ? newArticle = new NewArticle(this.driver) : newArticle;
    }
}
