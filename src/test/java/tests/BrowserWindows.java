package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindows {

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
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        PageMethods pageMethods = new PageMethods(driver);
        pageMethods.scrollPage(0,350);

        // Interactionam cu meniul/submeniul de pe site
        WebElement browserMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //browserMenu.click();
        elementMethod.clickElement(browserMenu);

        WebElement browserFormSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browserFormSubmenu.click();
        elementMethod.clickElement(browserFormSubmenu);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        //newTabButton.click();
        elementMethod.clickElement(newTabButton);

        // Interactionam cu un tab/window
        System.out.println(driver.getTitle()); //titlul paginii curente

        //List<String> tabs= new ArrayList<>(driver.getWindowHandles()); // gaseste cate tab-uri sunt deschise
        // Ne mutam cu focusul pe un anumit tab
        //driver.switchTo().window(tabs.get(1));
        windowsMethod.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl()); //url-ul paginii curente

        //inchidem tab-ul curent
        //driver.close();
        windowsMethod.closeCurrentTab();

        //driver.switchTo().window(tab.get(0));
        windowsMethod.switchSpecificTab(0);
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        //newWindowButton.click();
        elementMethod.clickElement(newWindowButton);

        //List<String> windowTabs= new ArrayList<>(driver.getWindowHandles()); // gaseste cate tab-uri sunt deschise
        // Ne mutam cu focusul pe un anumit tab
        windowsMethod.switchSpecificTab(1);
        //driver.switchTo().window(windowTabs.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.quit();


    }
}
