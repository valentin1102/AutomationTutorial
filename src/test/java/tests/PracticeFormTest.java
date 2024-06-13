package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {

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
        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsMenu.click();

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormSubmenu.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Valentin";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Stoica";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "blabla@yahoo.com";
        emailElement.sendKeys(userEmailValue);

        // //input[@name='gender']
        //Definim o logica generala de a selecta un element dintr-o lista

        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Male";
        switch (genderValue) {
            case "Male":
                genderElements.get(0).click();
                break;
            case "Female":
                genderElements.get(1).click();
                break;
            case "Other":
                genderElements.get(2).click();
                break;
        }
        WebElement numberElement = driver.findElement(By.id("userNumber"));
        String numberValue = "0741235321";
        numberElement.sendKeys(numberValue);

        //calendar
        WebElement calendarElement = driver.findElement(By.id("dateOfBirthInput"));
        calendarElement.click();
        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(dateOfBirthMonthElement);
        monthSelect.selectByVisibleText("February");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select((dateOfBirthYearElement));
        yearSelect.selectByVisibleText("1990");

        List<WebElement> weekDayElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month'))and @role='option']"));
        String weekDayValue = "22";
        for (Integer index = 0; index<weekDayElements.size(); index++) {
            if (weekDayElements.get(index).getText().equals(weekDayValue)){
                weekDayElements.get(index).click();
                break;
            }
        }

        //subjectsInput
        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Arts";
        subjectElement.sendKeys(subjectValue);
        subjectElement.sendKeys(Keys.ENTER);

        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports","Reading","Music");

        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) ;
            JavascriptExecutor jsclick = (JavascriptExecutor) driver;
            jsclick.executeScript("arguments[0].click();", hobbiesElements.get(index));

        }

    // uploadPicture Interactionam cu un fisier


        js.executeScript("window.scrollBy(0,350)", "");

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        String pictureValueElement = "Tema_1.txt";
        File file = new File("src/test/resources/Tema_1.txt");//full file path URL
        pictureElement.sendKeys(file.getAbsolutePath());

        //currentAddress
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Calea bla bla";
        addressElement.sendKeys(addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        stateElement.click();

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateInputValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        cityElement.click();

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        cityInputElement.sendKeys(cityInputValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        //Validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        //Facem o lista de webelements si sa o identificam cu find elements
        ////table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name" + " " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email" + " " + userEmailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender" + " " + genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile" + " " + numberValue);
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects" + " " + subjectValue);

        String actualHobbiesText = tableValues.get(6).getText();
        String expectedHobbiesText =  String.join(", ", actualHobbiesText);
        Assert.assertEquals(actualHobbiesText, expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture" + " " + pictureValueElement);
        Assert.assertEquals(tableValues.get(8).getText(), "Address" + " " + addressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City" + " " + stateInputValue + " " + cityInputValue);

        //WebElement closeElement = driver.findElement(By.id())
        //js.executeScript("arguments[0].click();", Close


// Obține valoarea din tabel
        //String actualHobbiesText = tableValues.get(6).getText();

// Formatează lista de valori așteptate pentru hobby-uri
        //String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValue);

// Compara valorile
        //Assert.assertEquals(actualHobbiesText, expectedHobbiesText);


    }
}
