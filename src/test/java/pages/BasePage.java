package pages;

import HelperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected ElementMethod elementMethods;
    protected PageMethods pageMethods;
    protected AlertMethods alertMethods;
    protected WindowsMethod windowsMethod;
    protected FrameMethods frameMethods;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        windowsMethod = new WindowsMethod(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
