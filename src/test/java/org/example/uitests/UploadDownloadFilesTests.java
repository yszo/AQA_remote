package org.example.uitests;

import com.google.common.io.Files;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


public class UploadDownloadFilesTests extends BaseTestClassUseProperties {
    @Test
    public void uploadTest() throws IOException, InterruptedException {
        File generatedFile = new File("files/generated.txt");
        String generatedContent = Files.readLines(generatedFile, Charset.defaultCharset()).toString().replaceAll("[\\[\\]]","");

       driver.findElement(By.id("textbox")).sendKeys(generatedContent);
       driver.findElement(By.id("create")).click();
       Thread.sleep(2000);
       driver.findElement(By.id("link-to-download")).click();

       File downloadedFile = MyFilesUtils.waitTillFileIsLoaded(new File("/Users/felis/Downloads", "easyinfo.txt"));
        String downloadedContent = Files.readLines(downloadedFile, Charset.defaultCharset()).toString().replaceAll("[\\[\\]]","");
        Assert.assertEquals(generatedContent,downloadedContent);
        new File("/Users/felis/Downloads", "easyinfo.txt").delete();
    }


}
