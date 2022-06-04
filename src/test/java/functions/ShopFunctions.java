package functions;

import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ShopPage;

import java.util.ArrayList;

public class ShopFunctions {

    ShopPage shopPage =  new ShopPage();
    HomePage homePage = new HomePage();
    private int index = 0;

    /**
     * Method to buy more of an item
     */
    public void buyItem(String name, int numberOfItem){
        ArrayList<String>  itemNameList = new ArrayList<>();
        itemNameList = shopPage.getItemNames();
        for(int i = 0 ; i < numberOfItem ; i++){
            index = 0;
            innerllop:for(String item : itemNameList){
                if(item.equalsIgnoreCase(name)){
                    break innerllop;
                }
                index++;
            };
            shopPage.clickBuyItemBtn(index);
        }
    }


    /**
     * Method to go to the Cart
     */
    public void gotoCart(){
        homePage.clickCartBtn();
    }
}
