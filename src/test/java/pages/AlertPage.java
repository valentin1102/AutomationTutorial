package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.info("The user clicks on the alertOK button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the alertOK successfully");
    }

    public void confirmationAlert(){
        pageMethods.scrollPage(0,365);
        LoggerUtility.info("The user scrolls down the page");
        elementMethods.clickElement(confirmAlertButton);
        LoggerUtility.info("The user clicks on the confirmAlert button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the confirmAlert successfully");
    }

    public void interactPromptButton(String text){
        elementMethods.clickElement(promptButton);
        LoggerUtility.info("The user clicks on the prompt button");
        alertMethods.fillAlert(text);
        LoggerUtility.info("The user submits the text in the prompt");
    }

    public void interactTimerButton(){
        elementMethods.clickElement(alertDelayButton);
        LoggerUtility.info("The user clicks on the alertDelay button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the alertDelay successfully");
    }
}
