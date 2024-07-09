package pages;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;

    public HomePage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement browserMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsMenu;



    public void navigatetoAlertMenu(){
        pageMethods.scrollPage(0,350);
        elementMethod.clickElement(browserMenu);
    }

    public void navigatetoFormsMenu(){
        pageMethods.scrollPage(0,365);
        elementMethod.clickElement(formsMenu);
    }

    public void navigatetoElementsMenu(){
        pageMethods.scrollPage(0,365);
        elementMethod.clickElement(elementsMenu);
    }
}
