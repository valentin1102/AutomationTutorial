package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubmenu;

    public void navigatetoWebTableMenu(){
        pageMethods.scrollPage(0,365);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(webTableSubmenu);
        LoggerUtility.info("The user clicked on the Web Table submenu");
    }
}
