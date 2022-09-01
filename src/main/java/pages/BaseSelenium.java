package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseSelenium
{
    public WebDriver driver;

    BaseSelenium(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(By locator) throws InterruptedException
    {
        highlighting(locator);
        Thread.sleep(2000);
        driver.findElement(locator).click();
        Thread.sleep(1000);
    }

    public void click(WebElement locator) throws InterruptedException
    {
        highlighting(locator);
        Thread.sleep(2000);
        locator.click();
        Thread.sleep(1000);
    }

    public void scrollDown() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        waitFor(1);
    }

    public void sendKeys(By locator, String value) throws InterruptedException
    {
        try
        {
            highlighting(locator);
            driver.findElement(locator).sendKeys(value);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void highlighting(By locators) throws InterruptedException
    {
        WebElement ele = driver.findElement(locators);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", ele);
        Thread.sleep(2000);
    }

    private void highlighting(WebElement locators) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", locators);
        Thread.sleep(2000);
    }

    public void waitFor(int i) throws InterruptedException
    {
        try
        {
            Thread.sleep(1000 * i);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
