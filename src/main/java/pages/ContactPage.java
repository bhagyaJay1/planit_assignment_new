package pages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends Base {

    /* Elements */
    By forenameTxtBox = By.id("forename");
    By surnameTxtBox = By.id("surname");
    By emailTxtBox = By.id("email");
    By telephoneTxtBox = By.id("telephone");
    By messageTxtBox = By.id("message");
    By submitBtn = By.className("btn-contact");
    By forenameErrorTxt = By.id("forename-err");
    By emailErrorTxt = By.id("email-err");
    By messageErrorText = By.id("message-err");
    By successMessageText = By.className("alert-success");

    /**
     * Method to pass values to Forename
     */
    public void typeForename(String text){
        type(forenameTxtBox, text);
    }

    /**
     * Method to pass values to Surname
     */
    public void typeSurname(String text){
        type(surnameTxtBox, text);
    }


    /**
     * Method to pass values to Email
     */
    public void typeEmail(String text){
        type(emailTxtBox, text);
    }


    /**
     * Method to pass values to TelephoneNumber
     */
    public void typeTelephoneNumber(String text){
        type(telephoneTxtBox, text);
    }


    /**
     * Method to pass values to Message
     */
    public void typeMessage(String text){
        type(messageTxtBox, text);
    }


    /**
     * Method to get the Submit button clicked
     */
    public void clickSubmitBtn(){
        click(submitBtn);
    }


    /**
     * Check if the error message is visible for Forename if empty
     */
    public boolean isForenameErrorVisible(){
        return isvisible(forenameErrorTxt);
    }

    /**
     * Check if the error message is visible for Email if empty
     */
    public boolean isEmailErrorVisible(){
        return isvisible(emailErrorTxt);
    }


    /**
     * Check if the error message is visible for Message if empty
     */
    public boolean isMessageErrorVisible(){
        return isvisible(messageErrorText);
    }

    public boolean isAlertSuccessMessageVisible(){
        waitUntil(15);
        return isvisible(successMessageText);
    }




}
