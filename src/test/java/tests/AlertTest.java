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
import pages.AlertPage;
import pages.AlertsWindowsPage;
import pages.HomePage;

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


        HomePage homepage = new HomePage(driver);
        homepage.navigatetoAlertMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToAlertsForm();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.interactAlertOk();
        alertPage.interactPromptButton("Valentin");
        alertPage.confirmationAlert();
        alertPage.interactTimerButton();
    }


}
