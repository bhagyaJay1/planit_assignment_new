package tests;

import common.Base;
import common.TestData;
import functions.CartFunctions;
import functions.ContactFunctions;
import functions.HomeFunctions;
import functions.ShopFunctions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class SaleTest extends Base {
    HomeFunctions homeFunctions = new HomeFunctions();
    ContactFunctions contactFunctions = new ContactFunctions();
    ShopFunctions shopFunctions = new ShopFunctions();
    CartFunctions cartFunctions = new CartFunctions();


    /**
     * Purpose:Verify the mandatory field validation in the Contact page
     */
    @Test(testName = "TC1_Contact page mandatory field validation")
    public void ContactPageMandatoryFieldsValidation(){
        homeFunctions.navigateToContactPage();
        waitUntil(3);
        contactFunctions.clickSubmitButton();
        HashMap<String, Boolean> errorAvailability = new HashMap<String, Boolean>();
        errorAvailability = contactFunctions.validateMandatoryFieldErrors();
        Assert.assertTrue(errorAvailability.get("forenameErrorAvailability"), "Forename error message is not available");
        Assert.assertTrue(errorAvailability.get("emailErrorAvailability"), "Email error message is not available");
        Assert.assertTrue(errorAvailability.get("messageErrorAvailability"), "Message error message is not available");
        contactFunctions.enterMandatoryFields("Tim", "john@abc.com", "This is a test message");
        errorAvailability.clear();
        errorAvailability = contactFunctions.validateMandatoryFieldErrors();
        Assert.assertFalse(errorAvailability.get("forenameErrorAvailability"), "Forename error message is available");
        Assert.assertFalse(errorAvailability.get("emailErrorAvailability"), "Email error message is available");
        Assert.assertFalse(errorAvailability.get("messageErrorAvailability"), "Message error message is available");
    }


    /**
     * Purpose:Verify the successful submission of Contact
     */
    @Test(testName = "TC2_Successful submission of Contact", invocationCount = 5)
    public void ContactPageSuccessfulSubmission(){
        homeFunctions.navigateToContactPage();
        contactFunctions.enterMandatoryFields("Tim", "john@abc.com", "This is a test message");
        contactFunctions.clickSubmitButton();
        Assert.assertTrue(contactFunctions.validateSuccesfulSubmissionMessage(), "Succesful submission message is not visible");
    }


    /**
     * Purpose:Verify added items in the Cart
     */
    @Test(testName = "TC3_Verify added items in the Cart")
    public void CartItemValidation(){
        homeFunctions.navigateToShopPage();
        shopFunctions.buyItem("Funny Cow", 2);
        shopFunctions.buyItem("Fluffy Bunny", 1);
        shopFunctions.gotoCart();
        Assert.assertEquals(cartFunctions.getCartItems(), "Funny Cow,Fluffy Bunny", "Items in the cart are incorrect");
    }

    /**
     * Purpose:Verify each product sub total and total value of cart items
     */
    @Test(testName = "TC4_Verify total of cart items")
    public void CartItemTotal(){
        homeFunctions.navigateToShopPage();
        shopFunctions.buyItem("Stuffed Frog", 2);
        shopFunctions.buyItem("Fluffy Bunny", 5);
        shopFunctions.buyItem("Valentine Bear", 3);
        shopFunctions.gotoCart();
        Assert.assertEquals(cartFunctions.getPricesOfItems(), "$" + String.valueOf(TestData.stuffedFrogPrice) + ",$" + String.valueOf(TestData.fluffyBunnyPrice) + ",$" + String.valueOf(TestData.valentineBearPrice), "Item prices in the cart are incorrect");
        Assert.assertEquals(cartFunctions.getSubTotalOfEachItemType(), "$" + String.valueOf(TestData.stuffedFrogPrice*2) + ",$" + String.valueOf(TestData.fluffyBunnyPrice*5) + ",$" + String.valueOf(TestData.valentineBearPrice*3), "Item subtotal of each item type in the cart are incorrect");

        double total = (TestData.stuffedFrogPrice*2) + (TestData.fluffyBunnyPrice*5) + (TestData.valentineBearPrice*3);
        Assert.assertEquals(cartFunctions.getTotal(), "Total: " + String.valueOf(total));
    }
}
