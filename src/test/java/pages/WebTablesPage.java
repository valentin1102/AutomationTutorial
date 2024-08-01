package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.info("The user clicked to add a new entry");
        elementMethods.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.info("The user fills firstname element with the value: " + firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.info("The user fills in the lastname element with the value: " + lastNameValue);
        elementMethods.fillElement(userEmailElement, UserEmailValue);
        LoggerUtility.info("The user fills in the useremailelement with the value: " + UserEmailValue);
        elementMethods.fillElement(ageElement, ageValue);
        LoggerUtility.info("The user fills in the ageelement with the value: " + ageValue);
        elementMethods.fillElement(salaryElement, salaryValue);
        LoggerUtility.info("The user fills in the salaryelement with the value: " + salaryValue);
        elementMethods.fillElement(departamentElement, departamentValue);
        LoggerUtility.info("The user fills in the departmentelement with the value: " + departamentValue);
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicked to submit the form");
    }

    public void editEntry(String editfirstNameValue, String editsalaryValue){
        elementMethods.clickElement(editElement);
        LoggerUtility.info("The user clicked to edit an existing entry");
        elementMethods.clearFillElement(editfirstNameElement,editfirstNameValue);
        LoggerUtility.info("The user edits firstname element with the value: " + editfirstNameValue);
        elementMethods.clearFillElement(editsalaryElement,editsalaryValue);
        LoggerUtility.info("The user edits the salaryelement  with the value: " + editsalaryValue);
        elementMethods.clickElement(editSubmitElement);
        LoggerUtility.info("The user clicked to submit the edited values");
    }
     public void deleteEntry(){
         elementMethods.clickElement(deleteElement);
         LoggerUtility.info("The user clicked to delete the entry");
     }

}
