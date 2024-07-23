package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeForm;

import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {
    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigatetoFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
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

        PracticeForm practiceForm = new PracticeForm(getDriver());
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