package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;



    public void interactWithNewTab(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(newTabButton);
        LoggerUtility.info("The user clicked on new tab button");
        windowsMethod.switchSpecificTab(1);
        LoggerUtility.info("The user switched on second tab");
        windowsMethod.closeCurrentTab();
        LoggerUtility.info("The user closed the current tab");
        windowsMethod.switchSpecificTab(0);
        LoggerUtility.info("The user switched back on the default tab");
    }

    public void interactWithNewWindow(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        newWindowButton.click();
        LoggerUtility.info("The user performed a click");
        windowsMethod.switchSpecificTab(1);
        LoggerUtility.info("The user switched to another tab");
        windowsMethod.closeCurrentTab();
        LoggerUtility.info("The user closed the current tab");
    }
}
