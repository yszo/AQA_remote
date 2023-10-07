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

public class HW08Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeClass() {
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().window();
    }

    @Test
    public void HillelTest() throws InterruptedException {
        driver.get("https://www.google.com/?hl=en-US");

        driver.findElement(By.name("q")).sendKeys("hillel it school");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        String actualString = elements.get(0).getText().toLowerCase();
        Assert.assertEquals(actualString, "hillel it school");

    }

    @Test
    public void LinkedinTest() throws InterruptedException {
        driver.get("https://www.google.com/?hl=en-US");

        driver.findElement(By.name("q")).sendKeys("Linkedin test");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        String actualString = elements.get(0).getText().toLowerCase();
        Assert.assertEquals(actualString, "linkedin test");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}