package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticle extends BaseSelenium
{
    WebDriver driver;

    @FindBy(xpath = ".//*[@href='#/editor/']")
    private WebElement newArticle;

    public NewArticle(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void postArticle(String a_title, String articleAbout, String articleDiscription, String tagName) throws InterruptedException
    {
        waitFor(2);
        click(newArticle);
        sendKeys(By.xpath(".//*[@ng-model='$ctrl.article.title']"), a_title);
        sendKeys(By.xpath(".//*[@ng-model='$ctrl.article.description']"), articleAbout);
        sendKeys(By.xpath(".//*[@ng-model='$ctrl.article.body']"), articleDiscription);
        sendKeys(By.xpath(".//*[@ng-model='$ctrl.tagField']"), tagName);
        click(By.xpath(".//*[@ng-click='$ctrl.submit()']"));
        waitFor(2);
    }

    public void postComment(String comment) throws InterruptedException
    {
        sendKeys(By.xpath(".//*[@ng-model='$ctrl.commentForm.body']"), comment);
        click(By.xpath(".//*[@type='submit']"));
        scrollDown();
        waitFor(2);
    }

    public void markFavorite() throws InterruptedException
    {
        click(By.xpath(".//*[@ng-class=\"{ active: $ctrl.listConfig.type === 'all' && !$ctrl.listConfig.filters }\"]"));
        waitFor(5);
        click(By.xpath(".//favorite-btn[@article='$ctrl.article']"));
    }

}
