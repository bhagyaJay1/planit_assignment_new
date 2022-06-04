package functions;

import pages.HomePage;

public class HomeFunctions {
    HomePage homePage = new HomePage();

    /**
     * Method to navigate to the Home page
     */
    public void navigateToHomePage(){
        homePage.clickHomeBtn();
    }

    /**
     * Method to navigate to the Shop page
     */
    public void navigateToShopPage(){
        homePage.clickShopBtn();
    }

    /**
     * Method to navigate to the Contact page
     */
    public void navigateToContactPage(){
        homePage.clickContactBtn();
    }
}
