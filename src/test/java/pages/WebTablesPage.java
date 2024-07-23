package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage {
    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departamentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editfirstNameElement;
    @FindBy(id = "salary")
    private WebElement editsalaryElement;
    @FindBy(id = "submit")
    private WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;



    public void addEntry(String firstNameValue, String lastNameValue, String UserEmailValue, String ageValue, String salaryValue,
                         String departamentValue){
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(userEmailElement, UserEmailValue);
        elementMethods.fillElement(ageElement, ageValue);
        elementMethods.fillElement(salaryElement, salaryValue);
        elementMethods.fillElement(departamentElement, departamentValue);
        elementMethods.clickElement(submitElement);
    }

    public void editEntry(String editfirstNameValue, String editsalaryValue){
        elementMethods.clickElement(editElement);
        elementMethods.clearFillElement(editfirstNameElement,editfirstNameValue);
        elementMethods.clearFillElement(editsalaryElement,editsalaryValue);
        elementMethods.clickElement(editSubmitElement);
    }
     public void deleteEntry(){
         elementMethods.clickElement(deleteElement);
     }

}
