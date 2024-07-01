package pages;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public WindowsMethod windowsMethod;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        windowsMethod = new WindowsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    public void interactWithNewTab(){
        pageMethods.scrollPage(0,350);
        elementMethod.clickElement(newTabButton);
        windowsMethod.switchSpecificTab(1);
        windowsMethod.closeCurrentTab();
        windowsMethod.switchSpecificTab(0);
    }

    public void interactWithNewWindow(){
        pageMethods.scrollPage(0,350);
        newWindowButton.click();
        windowsMethod.switchSpecificTab(1);
        windowsMethod.closeCurrentTab();
    }
}
