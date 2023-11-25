package org.example.uitests;

import org.example.uitests.driver.WebDriverFactory3;
import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClassUseProperties {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = WebDriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        goToUrl();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void afterClass() {

        WebDriverHolder.getInstance().driverQuit();
    }



    public void goToUrl(String url) {
 //       driver.get(url);
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));
    }

}
