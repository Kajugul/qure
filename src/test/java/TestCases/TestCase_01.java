package TestCases;

import Utility.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoard;

public class TestCase_01 extends BaseTest
{
    DashBoard dashBoard = null;
    String username = Constant.getUSERNAME();
    String email = Constant.getEmail();
    String password = Constant.getPASSWORD();

    @BeforeClass(alwaysRun = true)
    public void preCondition() throws InterruptedException
    {
        dashBoard = getDashboardObject();
    }

    @Test(priority = 0)
    public void signUp_Test_01() throws InterruptedException
    {
        log("doing signin in site.");
        dashBoard.getSignUp().doSignUp(username, password, email);
        dashBoard.getSignUp().signOut();
        log("Signin successfully.");
    }

    @Test(priority = 1)
    public void signIn_02() throws InterruptedException
    {
        log("doing signin");
        dashBoard.getSign().doLogin(email, password);
        log("sign in successfully.");
    }

    @Test(priority = 2)
    public void postArticle() throws InterruptedException
    {
        String title = "Test_Automation_" + RandomStringUtils.randomAlphabetic(5);
        String articleAbout = "Test_about_" + RandomStringUtils.randomAlphabetic(5);
        String articleDescription = "Test_Description_" + RandomStringUtils.randomAlphabetic(5);
        String tags = "Test_Tag_" + RandomStringUtils.randomAlphabetic(5);

        log("creating new article.");
        dashBoard.getNewArticle().postArticle(title, articleAbout, articleDescription, tags);
        log("New Article Created Successfully.");
    }

    @Test(priority = 3)
    public void postComment() throws InterruptedException
    {
        String comment = "Test_comment_" + RandomStringUtils.randomAlphabetic(5);
        log("updating comment on article");
        dashBoard.getNewArticle().postComment(comment);
        log("Comment on Post Created Successfully.");
    }

    @Test(priority = 4)
    public void markAsFavorite() throws InterruptedException
    {
        log("marking as favorite");
        dashBoard.getSign().goToGlobalFeed();
        dashBoard.getNewArticle().markFavorite();
        log("Article marked as successfully.");
    }

    private DashBoard getDashboardObject() throws InterruptedException
    {
        log("Initializing the WebDriver object");
        WebDriver driver = getWebDriver();
        log("WebDriver object initialized successfully.");
        driver.get(Constant.URL);
        return new DashBoard(driver);
    }
}
