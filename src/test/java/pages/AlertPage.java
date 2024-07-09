package pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "alertButton")
    public WebElement alertOKButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmAlertButton;

    @FindBy(id = "promtButton")
    public WebElement promptButton;

    @FindBy(id = "timerAlertButton")
    public WebElement alertDelayButton;

    public void interactAlertOk(){
        elementMethod.clickElement(alertOKButton);
        alertMethods.acceptAlert();
    }

    public void confirmationAlert(){
        pageMethods.scrollPage(0,365);
        elementMethod.clickElement(confirmAlertButton);
        alertMethods.acceptAlert();
    }

    public void interactPromptButton(String text){
        elementMethod.clickElement(promptButton);
        alertMethods.fillAlert(text);
    }

    public void interactTimerButton(){
        elementMethod.clickElement(alertDelayButton);
        alertMethods.acceptAlert();
    }
}
