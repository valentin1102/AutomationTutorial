package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver = driver;

    }

    public void switchFrame(String text){
        driver.switchTo().frame(text);
    }

    public void switchFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchDefault(){
        driver.switchTo().defaultContent();
    }
}
