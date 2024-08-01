package tests;

import objectData.PracticeFormObject;
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

        //Pregatim datele de test specifice
        PracticeFormObject testData = new PracticeFormObject("src/test/resources/testData/PracticeFormData.json");

        HomePage homePage = new HomePage(getDriver());
        homePage.navigatetoFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        PracticeForm practiceForm = new PracticeForm(getDriver());
        practiceForm.fillEntireForm(testData);

        practiceForm.validateEntireForm(testData);
    }
}