package ua.hillel.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class HW12Test {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String USER_EMAIL = "t@t.ca";
    private static final String USER_INVALID_EMAIL = "t!t.ca";


    @AfterMethod
    public void close() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window();
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
    }

    @Test
    public void RegistrationTest() throws InterruptedException {
        WebElement userEmailField = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        userEmailField.clear();
        userEmailField.sendKeys(USER_EMAIL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement buttonLogin = driver.findElement(By.id("SubmitCreate"));
        js.executeScript("arguments[0].click();", buttonLogin);
        Thread.sleep(2000);
        WebElement registrationHeader = driver.findElement(By.cssSelector("#noSlide>h1"));
        Assert.assertEquals(true, registrationHeader.isDisplayed());
    }

    @Test
    public void ContactsTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement menuItem = driver.findElement(By.cssSelector("ul.toggle-footer > li.item:nth-of-type(5) > a"));
        js.executeScript("arguments[0].click();", menuItem);
        String checkHeader =  driver.findElement(By.cssSelector("div#center_column > h1.page-heading")).getText();
        Assert.assertEquals(checkHeader, "CUSTOMER SERVICE - CONTACT US");
    }

}
