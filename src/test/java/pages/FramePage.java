package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement iFrameText;

    @FindBy(id = "sampleHeading")
    private WebElement iFrameText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrames;

    public void interactWithBigIframe(){

        frameMethods.switchFrame("frame1");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iFrameText.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.switchDefault();
        LoggerUtility.info("The user switches to primary frame");
    }

    public void interactWithSmallIframe(){
        frameMethods.switchFrame("frame2");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iFrameText2.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.switchDefault();
        LoggerUtility.info("The user switches to primary frame");
    }

    public void interactWithNestedFrame(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(nestedFrames);
        LoggerUtility.info("The user interacts with a nested frame");
    }
}
