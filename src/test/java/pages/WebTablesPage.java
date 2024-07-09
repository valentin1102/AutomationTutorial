package pages;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {
    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;

    public WebTablesPage(WebDriver driver){
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement userEmailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departamentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(id = "edit-record-4")
    public WebElement editElement;
    @FindBy(id = "firstName")
    public WebElement editfirstNameElement;
    @FindBy(id = "salary")
    public WebElement editsalaryElement;
    @FindBy(id = "submit")
    public WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addEntry(String firstNameValue, String lastNameValue, String UserEmailValue, String ageValue, String salaryValue,
                         String departamentValue){
        elementMethod.clickElement(addElement);
        elementMethod.fillElement(firstNameElement, firstNameValue);
        elementMethod.fillElement(lastNameElement, lastNameValue);
        elementMethod.fillElement(userEmailElement, UserEmailValue);
        elementMethod.fillElement(ageElement, ageValue);
        elementMethod.fillElement(salaryElement, salaryValue);
        elementMethod.fillElement(departamentElement, departamentValue);
        elementMethod.clickElement(submitElement);
    }

    public void editEntry(String editfirstNameValue, String editsalaryValue){
        elementMethod.clickElement(editElement);
        elementMethod.clearFillElement(editfirstNameElement,editfirstNameValue);
        elementMethod.clearFillElement(editsalaryElement,editsalaryValue);
        elementMethod.clickElement(editSubmitElement);
    }
     public void deleteEntry(){
         elementMethod.clickElement(deleteElement);
     }

}
