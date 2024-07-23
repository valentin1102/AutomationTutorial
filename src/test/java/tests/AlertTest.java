package tests;

import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {


        HomePage homepage = new HomePage(getDriver());
        homepage.navigatetoAlertMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToAlertsForm();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interactAlertOk();
        alertPage.interactPromptButton("Valentin");
        alertPage.confirmationAlert();
        alertPage.interactTimerButton();
    }


}
