package tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethod;
import HelperMethods.FrameMethods;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demoqa.com/");

        // Facem browserul in modul maximize/
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        // Facem un scroll la pagina pentru vizibilitate
        pageMethods.scrollPage(0,350);

        // Interactionam cu meniul/submeniul de pe site
        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethod.clickElement(alertsMenu);

        WebElement framesSubmenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethod.clickElement(framesSubmenu);

        //ne mutam cu focusul pe un iFrame
        frameMethods.switchFrame("frame1");

        WebElement iFrameText=driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText.getText());

        //ne intoarcem cu focusul la frame-ul default
        frameMethods.switchDefault();

        frameMethods.switchFrame("frame2");

        WebElement iFrameText2=driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText2.getText());

        frameMethods.switchDefault();

        WebElement nestedFrames = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethod.clickElement(nestedFrames);

        //interactionam cu iframe in iframe
        frameMethods.switchFrame("frame1");

        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        frameMethods.switchFrame(childFrame);

        WebElement childText = driver.findElement(By.xpath("//p"));
        System.out.println(childText.getText());
    }
}
