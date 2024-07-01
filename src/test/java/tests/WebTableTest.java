package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;


    @Test
    public void metodaTest() {


        // Deschidem un browser
        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demoqa.com/");

        // Facem browserul in modul maximize/
        driver.manage().window().maximize();

        //Obiecte
        PageMethods pageMethods = new PageMethods(driver);
        ElementMethod elementMethod = new ElementMethod(driver);

        // Facem un scroll la pagina pentru vizibilitate
        pageMethods.scrollPage(0,365);

        // Interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethod.clickElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethod.clickElement(webTableSubmenu);

        // Definim un element dupa ID
        // Test 1: Adaug un nou entry
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethod.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Valentin";
        elementMethod.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Stoica";
        elementMethod.fillElement(lastNameElement, lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String UserEmailValue = "valentin@stoica.com";
        elementMethod.fillElement(userEmailElement, UserEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "34";
        elementMethod.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        elementMethod.fillElement(salaryElement, salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "CFS";
        elementMethod.fillElement(departmentElement, departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethod.clickElement(submitElement);

        // Test 2: Modific un entry existent

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethod.clickElement(editElement);

        WebElement editfirstNameElement = driver.findElement(By.id("firstName"));
        String editfirstNameValue = "Alexei";
        elementMethod.clearFillElement(editfirstNameElement, editfirstNameValue);


        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        String editsalaryValue = "9000";
        elementMethod.clearFillElement(editsalaryElement, editsalaryValue);

        WebElement editsubmitElement = driver.findElement(By.id("submit"));
        elementMethod.clickElement(editsubmitElement);

        // Test 3: Stergem un entry existent

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethod.clickElement(deleteElement);

        //Test 4: Inchidem browserul
        
         // driver.quit();
    }

}
