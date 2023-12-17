package org.example.uitests.pages.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadHerokuPage {

    @FindBy(xpath = "//*[@id=\"file-upload\"]")
    private WebElement fileUpload;

    @FindBy(id="file-submit")
    private WebElement fileSubmitButton;

    @FindBy(id="uploaded-files")
    private WebElement uploadedFiles;

    @FindBy(linkText="generated.txt")
    private WebElement fileName;

    public UploadHerokuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public UploadHerokuPage() {
        super();
    }



    public UploadHerokuPage UploadFile(String filePath) {
        System.out.println(fileUpload);
        fileUpload.sendKeys(filePath);
        fileSubmitButton.click();
        return this;
    }
    public String trimFileName() {
        String fileName =  uploadedFiles.getText().trim();
        return fileName;
    }
}