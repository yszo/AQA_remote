package org.example.uitests;

import com.google.common.io.Files;
import org.example.uitests.utils.MyFilesUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.uitests.pages.easyselenium.UploadPage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


public class UploadDownloadFilesTests extends BaseTestClass {
    @BeforeMethod
    public void beforeMethod() {
        goToEasySeleniumUrl();
    }


    @Test

    public void uploadTest() throws IOException, InterruptedException {
        File generatedFile = new File("files/generated.txt");
        String generatedContent = Files.readLines(generatedFile, Charset.defaultCharset()).toString().replaceAll("[\\[\\]]","");

       UploadPage uploadPage = new UploadPage()
                    .SendContent(generatedContent);


       File downloadedFile = MyFilesUtils.waitTillFileIsLoaded(new File("/Users/felis/Downloads", "easyinfo.txt"));
        String downloadedContent = Files.readLines(downloadedFile, Charset.defaultCharset()).toString().replaceAll("[\\[\\]]","");
        Assert.assertEquals(generatedContent,downloadedContent);
        new File("/Users/felis/Downloads", "easyinfo.txt").delete();
    }


}
