package pages;

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
        elementMethods.clickElement(newTabButton);
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
