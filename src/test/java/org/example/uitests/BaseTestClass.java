package org.example.uitests;

import org.example.uitests.driver.WebDriverFactory3;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {


        driver = WebDriverFactory3.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }


}
