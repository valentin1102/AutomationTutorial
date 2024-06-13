package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowsMethod {

    public WebDriver driver;

    public WindowsMethod(WebDriver driver) {
        this.driver = driver;
    }

    //Metode generale pentru interactiunea cu tab/window

    public void switchSpecificTab(Integer index){
        List<String> windowTabs= new ArrayList<>(driver.getWindowHandles()); // gaseste cate tab-uri sunt deschise
        // Ne mutam cu focusul pe un anumit tab
        driver.switchTo().window(windowTabs.get(index));
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
