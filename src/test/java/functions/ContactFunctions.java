package functions;

import pages.ContactPage;

import java.util.HashMap;

public class ContactFunctions {
    ContactPage contactPage = new ContactPage();

    /**
     * Method to click on Submit button
     */
    public void clickSubmitButton(){
        contactPage.clickSubmitBtn();
    }

    /**
     * Method to validate availability of all mandatory fields in the Contact page
     */
    public HashMap<String, Boolean> validateMandatoryFieldErrors(){
        HashMap<String, Boolean> availability = new HashMap<String, Boolean>();
        availability.put("forenameErrorAvailability", contactPage.isForenameErrorVisible());
        availability.put("emailErrorAvailability", contactPage.isEmailErrorVisible());
        availability.put("messageErrorAvailability", contactPage.isMessageErrorVisible());
        return availability;
    }

    /**
     * Method to pass values to the mandatory fields in the Contact page
     */
    public void enterMandatoryFields(String forename, String email, String message){
        contactPage.typeForename(forename);
        contactPage.typeEmail(email);
        contactPage.typeMessage(message);
    }

    /**
     * Method to validate successful submission of the contact details
     */
    public Boolean validateSuccesfulSubmissionMessage(){

        return contactPage.isAlertSuccessMessageVisible();
    }
}
