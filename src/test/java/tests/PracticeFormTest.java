package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
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

        //Obiecte
        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods pageMethods = new PageMethods(driver);

        // Facem un scroll la pagina pentru vizibilitate
        pageMethods.scrollPage(0,365);

        // Interactionam cu meniul/submeniul de pe site
        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethod.clickElement(formsMenu);

        WebElement practiceFormSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethod.clickElement(practiceFormSubmenu);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Valentin";
        elementMethod.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Stoica";
        elementMethod.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "blabla@yahoo.com";
        elementMethod.fillElement(emailElement, userEmailValue);

        //Definim o logica generala de a selecta un element dintr-o lista

        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Male";
        switch (genderValue) {
            case "Male":
                elementMethod.clickElement(genderElements.get(0));
                break;
            case "Female":
                elementMethod.clickElement(genderElements.get(1));
                break;
            case "Other":
                elementMethod.clickElement(genderElements.get(2));
                break;
        }
        WebElement numberElement = driver.findElement(By.id("userNumber"));
        String numberValue = "0741235321";
        elementMethod.fillElement(numberElement, numberValue);

        //calendar
        WebElement calendarElement = driver.findElement(By.id("dateOfBirthInput"));
        elementMethod.clickElement(calendarElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        elementMethod.selectByTextElement(dateOfBirthMonthElement, "August" );

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        elementMethod.selectByValue(dateOfBirthYearElement, "1990");

        List<WebElement> weekDayElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month'))and @role='option']"));
        String weekDayValue = "22";
        for (Integer index = 0; index<weekDayElements.size(); index++) {
            if (weekDayElements.get(index).getText().equals(weekDayValue)){
                elementMethod.clickElement(weekDayElements.get(index));
                break;
            }
        }

        //subjectsInput
        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Arts";
        elementMethod.fillElement(subjectElement, subjectValue);
        elementMethod.pressElement(subjectElement, Keys.ENTER);

        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports","Reading","Music");

        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) ;
            elementMethod.clickJSElement(hobbiesElements.get(index));
        }

        pageMethods.scrollPage(0,365);

        // uploadPicture Interactionam cu un fisier
        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        String pictureValueElement = "Tema_1.txt";
        File file = new File("src/test/resources/Tema_1.txt");//full file path URL
        elementMethod.fillElement(pictureElement, file.getAbsolutePath());

        //currentAddress
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Calea bla bla";
        elementMethod.fillElement(addressElement, addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        elementMethod.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        elementMethod.fillElement(stateInputElement, stateInputValue);
        elementMethod.pressElement(stateInputElement, Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        elementMethod.clickElement(cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        elementMethod.fillElement(cityInputElement, cityInputValue);
        elementMethod.pressElement(cityInputElement, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethod.clickElement(submitElement);

        //Validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        //Facem o lista de webelements si sa o identificam cu find elements

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

        WebElement closeButtonElement = driver.findElement(By.id("closeLargeModal"));
        elementMethod.clickElement(closeButtonElement);
    }
}
