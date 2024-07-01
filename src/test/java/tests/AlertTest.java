package tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
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
        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods pageMethods = new PageMethods(driver);

        // Facem un scroll la pagina pentru vizibilitate
        pageMethods.scrollPage(0,350);

        // Interactionam cu meniul/submeniul de pe site
        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethod.clickElement(alertsMenu);

        WebElement alertsSubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethod.clickElement(alertsSubmenu);

        //Interactionam cu o alerta
        WebElement alertOKButton = driver.findElement(By.id("alertButton"));
        elementMethod.clickElement(alertOKButton);

        alertMethods.acceptAlert();

        //Interactionam cu confirm button
        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
        elementMethod.clickElement(confirmAlertButton);

        alertMethods.dismissButton();

        //Interactionam cu prompt button
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        elementMethod.clickElement(promptButton);

        alertMethods.fillAlert("Valentin");

        //Interactionam cu o alerta pentru care trebuie sa asteptam 5 secunde
        WebElement alertDelayButton = driver.findElement(By.id("timerAlertButton"));
        elementMethod.clickElement(alertDelayButton);

        alertMethods.acceptAlert();

    }


}
