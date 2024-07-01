package tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethod;
import HelperMethods.FrameMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;

import java.time.Duration;

public class FrameTest {

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

        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.navigatetoAlertMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramePage();


        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigIframe();
        framePage.interactWithSmallIframe();
        framePage.interactWithNestedFrame();

        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interactWithNestedFrame();
    }
}
