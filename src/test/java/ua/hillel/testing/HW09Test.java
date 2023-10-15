package ua.hillel.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class HW09Test {

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

        WebElement buttonLogin = driver.findElement(By.cssSelector("#SubmitCreate"));
        buttonLogin.click();
        Thread.sleep(5000);
        WebElement registrationHeader = driver.findElement(By.cssSelector("#noSlide>h1"));
        Assert.assertNotNull(registrationHeader);
    }

    @Test
    public void InvalidEmailTest() throws InterruptedException {
        WebElement userEmailField = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        userEmailField.clear();
        userEmailField.sendKeys(USER_INVALID_EMAIL);
        WebElement buttonLogin = driver.findElement(By.cssSelector("#SubmitCreate"));
        buttonLogin.click();

        WebElement alert = driver.findElement(By.cssSelector("#create_account_error"));
        Assert.assertNotNull(alert);
    }

}