package org.example.uitests.pages.easyselenium;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage extends BasePage {



    @FindBy(id="textbox")
    private WebElement textbox;

    @FindBy (id="create")
    private WebElement createButton;

    @FindBy(id="link-to-download")
    private WebElement downloadButton;

    public UploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public UploadPage() {
       super();
    }


    public UploadPage SendContent(String generatedContent) throws InterruptedException {
        textbox.clear();
        textbox.sendKeys(generatedContent);
        clickButton(createButton);
        Thread.sleep(2000);
        clickButton(downloadButton);
        return this;
    }

    private void clickButton (WebElement element) {
       element.click();
    }
}
