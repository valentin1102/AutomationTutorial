package pages;

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
        System.out.println(iFrameText.getText());
        frameMethods.switchDefault();
    }

    public void interactWithSmallIframe(){
        frameMethods.switchFrame("frame2");
        System.out.println(iFrameText2.getText());
        frameMethods.switchDefault();
    }

    public void interactWithNestedFrame(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(nestedFrames);
    }
}
