package pages;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;

    public AlertsWindowsPage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserFormSubmenu;

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesSubmenu;

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubmenu;

    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,350);
        elementMethod.clickElement(browserFormSubmenu);
    }


    public void navigateToFramePage(){
        pageMethods.scrollPage(0,350);
        elementMethod.clickElement(framesSubmenu);
    }

    public void navigateToAlertsForm(){
        pageMethods.scrollPage(0,350);
        elementMethod.clickElement(alertsSubmenu);
    }

}