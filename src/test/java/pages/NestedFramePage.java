package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramePage extends BasePage {
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;

    @FindBy(xpath = "//p")
    private WebElement childText;



    public void interactWithNestedFrame(){
        frameMethods.switchFrame("frame1");
        frameMethods.switchFrame(childFrame);
        System.out.println(childText.getText());
        frameMethods.switchDefault();
    }

}
