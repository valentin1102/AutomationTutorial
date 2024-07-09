package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;

public class WebTableTest {

    public WebDriver driver;


    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigatetoElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navigatetoWebTableMenu();

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.addEntry("Valentin", "Stoica","valentin@yahoo.com", "34","1900","CFS");
        webTablesPage.editEntry("Alexei", "1000");
        webTablesPage.deleteEntry();
    }

}
