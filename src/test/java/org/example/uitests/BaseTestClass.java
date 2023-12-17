package org.example.uitests;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.utils.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
    @BeforeSuite
    public void beforeClass() {
        WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToEasySeleniumUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.easyselenium.url"));
    }
    public void goToEasyHerokuUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.heroku.url"));
    }
    public void goToPart(String part) {
        goToUrl(ConfigProvider.getInstance().getProperty("app.heroku.url") + part);
    }


}