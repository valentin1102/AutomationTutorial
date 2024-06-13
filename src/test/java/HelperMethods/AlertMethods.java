package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    public WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Definim metode generale pentru interactiunea cu alerte
    public void waitForAlert(){
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDriver.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert waitConfirmButton = driver.switchTo().alert();
        System.out.println(waitConfirmButton.getText());
        waitConfirmButton.accept();
    }

    public void dismissButton(){
        waitForAlert();
        Alert waitConfirmButton = driver.switchTo().alert();
        System.out.println(waitConfirmButton.getText());
        waitConfirmButton.dismiss();
    }

    public void fillAlert(String value){
        Alert promptInput = driver.switchTo().alert();
        System.out.println(promptInput.getText());
        promptInput.sendKeys(value);
        promptInput.accept();
    }
}
