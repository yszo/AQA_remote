package org.example.uitests;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.easyselenium.UploadPage;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.uitests.pages.heroku.UploadHerokuPage;

import java.io.File;
import java.io.IOException;

public class UploadDownloadHerokuTest extends BaseTestClass {
    public void beforeClass() {
        WebDriverHolder.getInstance().getDriver();
    }
    public void beforeMethod() {
        goToEasyHerokuUrl();
    }

    @Test
    public void uploadTest() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();
        String filePath = file.getAbsolutePath();
        goToPart("upload");
        Thread.sleep(3000);
        UploadHerokuPage uploadHerokuPage = new UploadHerokuPage().UploadFile(filePath);

        String uploadedFileName = uploadHerokuPage.trimFileName();

        Assert.assertEquals(uploadedFileName, file.getName());

        goToPart("download");
//        Assert.assertTrue(uploadHerokuPage.fileName.isDisplayed());

    }

//    @Test
//    public void downloadTest() throws IOException, InterruptedException {
//        File file = MyFilesUtils.generateLoremFile();
//        goToPart("upload");
//        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
//
//        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());
//
//        goToPart("download");
//        driver.findElement(By.linkText(file.getName())).click();
//
//        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("/Users/felis/Downloads", file.getName()));
//
//        Assert.assertEquals(file.length(), file1.length());
//
//        file1.deleteOnExit();
//
//    }

}