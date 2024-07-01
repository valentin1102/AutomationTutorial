package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {

    public WebDriver driver;

    @Test
    public void methodTest(){

        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demoqa.com/");

        // Facem browserul in modul maximize/
        driver.manage().window().maximize();

        //definim un obiect de tipul window method
        WindowsMethod windowsMethod = new WindowsMethod(driver);
        ElementMethod elementMethod = new ElementMethod(driver);

        // Facem un scroll la pagina pentru vizibilitate
        PageMethods pageMethods = new PageMethods(driver);
        pageMethods.scrollPage(0,350);

        // Interactionam cu meniul/submeniul de pe site
        WebElement browserMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethod.clickElement(browserMenu);

        WebElement browserFormSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethod.clickElement(browserFormSubmenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementMethod.clickElement(newTabButton);

        windowsMethod.switchSpecificTab(1);

        windowsMethod.closeCurrentTab();

        windowsMethod.switchSpecificTab(0);

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        elementMethod.clickElement(newWindowButton);


        windowsMethod.switchSpecificTab(1);
        windowsMethod.closeCurrentTab();

        driver.quit();


    }
}
