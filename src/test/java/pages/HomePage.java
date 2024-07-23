package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement browserMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    public void navigatetoAlertMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(browserMenu);
    }

    public void navigatetoFormsMenu(){
        pageMethods.scrollPage(0,365);
        elementMethods.clickElement(formsMenu);
    }

    public void navigatetoElementsMenu(){
        pageMethods.scrollPage(0,365);
        elementMethods.clickElement(elementsMenu);
    }
}
