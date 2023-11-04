package ua.hillel.testing;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FramesTests extends BaseTestClass{

    @Test(dataProvider = "dataProviderFrames")
    public void switchToFrame(String frameLocation, String frameName, String frameText) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(frameLocation);
        if (frameLocation.equals("frame-top")) {
            driver.switchTo().frame(frameName);
        }

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, frameText);

        driver.switchTo().defaultContent();

        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
    }


    @DataProvider
    public Object[][] dataProviderFrames () {
        return new Object[][] {
                {"frame-bottom", "frame-bottom", "BOTTOM"},
                {"frame-top", "frame-left", "LEFT"},
                {"frame-top", "frame-middle", "MIDDLE"},
                {"frame-top", "frame-right", "RIGHT"}
        };
    }
}
