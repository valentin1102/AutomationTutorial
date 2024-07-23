package tests;

import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigatetoAlertMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToFramePage();


        FramePage framePage = new FramePage(getDriver());
        framePage.interactWithBigIframe();
        framePage.interactWithSmallIframe();
        framePage.interactWithNestedFrame();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.interactWithNestedFrame();
    }
}
