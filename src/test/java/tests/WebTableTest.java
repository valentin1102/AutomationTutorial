package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // Facem un scroll la pagina pentru vizibilitate
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTableSubmenu.click();

        // Definim un element dupa ID
        // Test 1: Adaug un nou entry
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Valentin";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Stoica";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String UserEmailValue = "valentin@stoica.com";
        userEmailElement.sendKeys(UserEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "34";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "CFS";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        // Test 2: Modific un entry existent

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editfirstNameElement = driver.findElement(By.id("firstName"));
        String editfirstNameValue = "Alexei";
        editfirstNameElement.clear();
        editfirstNameElement.sendKeys(editfirstNameValue);


        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        String editsalaryValue = "9000";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editsubmitElement = driver.findElement(By.id("submit"));
        editsubmitElement.click();

        // Test 3: Stergem un entry existent

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        //Test 4: Inchidem browserul
        
         // driver.quit();
    }

}
