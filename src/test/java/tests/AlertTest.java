package tests;

import HelperMethods.AlertMethods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demoqa.com/");

        // Facem browserul in modul maximize/
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        AlertMethods alertMethods = new AlertMethods(driver);

        // Facem un scroll la pagina pentru vizibilitate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Interactionam cu meniul/submeniul de pe site
        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsMenu.click();

        WebElement alertsSubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsSubmenu.click();

        //Interactionam cu o alerta
        WebElement alertOKButton = driver.findElement(By.id("alertButton"));
        alertOKButton.click();

        alertMethods.acceptAlert();

//        Alert alertOK = driver.switchTo().alert();
//        System.out.println(alertOK.getText());
//        alertOK.accept();

        //Interactionam cu o alerta cu timer


        //Interactionam cu confirm button
        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
        confirmAlertButton.click();

        alertMethods.dismissButton();

//        Alert alertConfirmButton = driver.switchTo().alert();
//        System.out.println(alertConfirmButton.getText());
//        alertConfirmButton.accept();

        //Interactionam cu prompt button
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();

        alertMethods.fillAlert("Valentin");

//        Alert promptInput = driver.switchTo().alert();
//        System.out.println(promptInput.getText());
//        promptInput.sendKeys("Valentin");
//        promptInput.accept();

        //Interactionam cu o alerta pentru care trebuie sa asteptam 5 secunde
        WebElement alertDelayButton = driver.findElement(By.id("timerAlertButton"));
        alertDelayButton.click();

        alertMethods.acceptAlert();

        //definim un wait explicit
//        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(10));
//        waitDriver.until(ExpectedConditions.alertIsPresent());
//
//        Alert waitConfirmButton = driver.switchTo().alert();
//        System.out.println(waitConfirmButton.getText());
//        waitConfirmButton.accept();


    }


}
