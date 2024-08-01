package objectData;

import java.util.List;

public class PracticeFormObject extends GeneralObjects {

    public PracticeFormObject(String filePath) {
        fromJsontoObject(filePath);
    }

    private String firstNameValue;
    private String lastNameValue;
    private String userEmailValue;
    private String genderValue;
    private String userNumberValue;
    private String dateOfBirthDaysValue;
    private String subjectsInputValue;
    private List<String> hobbiesValue;
    private String picturePathValue;
    private String currentAddressValue;
    private String stateElementValue;
    private String cityValue;

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getUserEmailValue() {
        return userEmailValue;
    }

    public void setUserEmailValue(String userEmailValue) {
        this.userEmailValue = userEmailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getUserNumberValue() {
        return userNumberValue;
    }

    public void setUserNumberValue(String userNumberValue) {
        this.userNumberValue = userNumberValue;
    }

    public String getDateOfBirthDaysValue() {
        return dateOfBirthDaysValue;
    }

    public void setDateOfBirthDaysValue(String dateOfBirthDaysValue) {
        this.dateOfBirthDaysValue = dateOfBirthDaysValue;
    }

    public String getSubjectsInputValue() {
        return subjectsInputValue;
    }

    public void setSubjectsInputValue(String subjectsInputValue) {
        this.subjectsInputValue = subjectsInputValue;
    }

    public List<String> getHobbiesValue() {
        return hobbiesValue;
    }

    public void setHobbiesValue(List<String> hobbiesValue) {
        this.hobbiesValue = hobbiesValue;
    }

    public String getPicturePathValue() {
        return picturePathValue;
    }

    public void setPicturePathValue(String picturePathValue) {
        this.picturePathValue = picturePathValue;
    }

    public String getCurrentAddressValue() {
        return currentAddressValue;
    }

    public void setCurrentAddressValue(String currentAddressValue) {
        this.currentAddressValue = currentAddressValue;
    }

    public String getStateElementValue() {
        return stateElementValue;
    }

    public void setStateElementValue(String stateElementValue) {
        this.stateElementValue = stateElementValue;
    }

    public String getCityValue() {
        return cityValue;
    }

    public void setCityValue(String cityValue) {
        this.cityValue = cityValue;
    }
}
