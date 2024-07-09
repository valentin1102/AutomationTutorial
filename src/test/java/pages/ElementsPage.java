package pages;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;

    public ElementsPage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubmenu;

    public void navigatetoWebTableMenu(){
        pageMethods.scrollPage(0,365);
        elementMethod.clickElement(webTableSubmenu);
    }
}
