package pages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShopPage extends Base {

    /* Elements */
    private By itemName = By.className("product-title");
    private By itemBuyBtn = By.className("btn-success");

    /**
     * Method to get Item list in the shop page
     */
    public ArrayList<String> getItemNames(){
        waitUntil(3);
        List<WebElement> elements = getWebElements(itemName);
        ArrayList<String> itemNameList = new ArrayList<>();
        for(WebElement item : elements){
            itemNameList.add(item.getText());
        }
        return itemNameList;
    }

    /**
     * Method to click Buy button of the given item
     */
    public void clickBuyItemBtn(int index){
        clickFromList(itemBuyBtn, index);
    }
}
