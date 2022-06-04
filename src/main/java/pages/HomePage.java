package pages;
import org.apache.log4j.Logger;
import common.Base;
import org.openqa.selenium.By;

public class HomePage extends Base {

    /* Elements */
    private By startShoppingBtn = By.xpath("//a[@class='btn btn-success btn-large']");
    private By homeBtn = By.id("nav-home");
    private By shopBtn = By.id("nav-shop");
    private By contactBtn = By.id("nav-contact");
    private By cartBtn = By.id("nav-cart");


    /**
     * Method to click StartShopping Button
     */
    public void clickStartShoppingBtn(){
        click(startShoppingBtn);
    }

    /**
     * Method to click Home Button
     */
    public void clickHomeBtn(){ click(homeBtn);
    }

    /**
     * Method to click Shop Button
     */
    public void clickShopBtn(){
        click(shopBtn);
    }

    /**
     * Method to click Contact Button
     */
    public void clickContactBtn(){
        click(contactBtn);
    }

    /**
     * Method to click Cart Button
     */
    public void clickCartBtn(){
        click(cartBtn);
    }
}
