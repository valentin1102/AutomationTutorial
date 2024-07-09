package tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeForm;

import pages.PracticeForm;
import pages.PracticeForm;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;


    @Test
    public void metodaTest() {


        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigatetoFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.navigateToPracticeForm();

        String firstNameValue = "Valentin";
        String lastNameValue = "Stoica";
        String userEmailValue = "blabla@yahoo.com";
        String genderValue = "Male";
        String userNumberValue = "0755939013";
        String dateOfBirthDaysValue = "11";
        String subjectsInputValue = "Arts";
        List<String> hobbiesValue = Arrays.asList("Sports", "Music");
        String picturePathValue = "Tema_1.txt";
        String currentAddressValue = "Str. Hohoho";
        String stateElementValue = "Uttar Pradesh";
        String cityValue = "Agra";

        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.fillEntireForm(firstNameValue, lastNameValue, userEmailValue,
                genderValue, userNumberValue, dateOfBirthDaysValue, subjectsInputValue, hobbiesValue,
                picturePathValue, currentAddressValue, stateElementValue, cityValue);

        practiceForm.validateEntireForm(firstNameValue,
                lastNameValue, userEmailValue, genderValue,
                userNumberValue, subjectsInputValue, hobbiesValue,
                picturePathValue, currentAddressValue,
                stateElementValue, cityValue);
    }
}