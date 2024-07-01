package pages;

import HelperMethods.ElementMethod;
import HelperMethods.FrameMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    public NestedFramePage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;

    @FindBy(xpath = "//p")
    public WebElement childText;

    public void interactWithNestedFrame(){
        frameMethods.switchFrame("frame1");
        frameMethods.switchFrame(childFrame);
        System.out.println(childText.getText());
        frameMethods.switchDefault();
    }

}
