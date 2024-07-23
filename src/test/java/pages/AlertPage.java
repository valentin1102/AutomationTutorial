package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOKButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmAlertButton;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(id = "timerAlertButton")
    private WebElement alertDelayButton;

    public void interactAlertOk(){
        elementMethods.clickElement(alertOKButton);
        alertMethods.acceptAlert();
    }

    public void confirmationAlert(){
        pageMethods.scrollPage(0,365);
        elementMethods.clickElement(confirmAlertButton);
        alertMethods.acceptAlert();
    }

    public void interactPromptButton(String text){
        elementMethods.clickElement(promptButton);
        alertMethods.fillAlert(text);
    }

    public void interactTimerButton(){
        elementMethods.clickElement(alertDelayButton);
        alertMethods.acceptAlert();
    }
}
