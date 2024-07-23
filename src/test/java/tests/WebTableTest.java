package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {


    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigatetoElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.navigatetoWebTableMenu();

        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.addEntry("Valentin", "Stoica","valentin@yahoo.com", "34","1900","CFS");
        webTablesPage.editEntry("Alexei", "1000");
        webTablesPage.deleteEntry();
    }

}
