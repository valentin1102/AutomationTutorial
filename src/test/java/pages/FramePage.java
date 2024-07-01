package pages;

import HelperMethods.ElementMethod;
import HelperMethods.FrameMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement iFrameText;

    @FindBy(id = "sampleHeading")
    public WebElement iFrameText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    public WebElement nestedFrames;



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
        elementMethod.clickElement(nestedFrames);
    }
}
