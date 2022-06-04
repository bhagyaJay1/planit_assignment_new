package pages;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Cartpage extends Base {

    /* Elements */
    private String itemNameLbl = "//table[@class='table table-striped cart-items']/tbody/tr[replace]/td[1]";
    private String itemPriceLbl = "//table[@class='table table-striped cart-items']/tbody/tr[replace]/td[2]";
    private String itemSubTotalLbl = "//table[@class='table table-striped cart-items']/tbody/tr[replace]/td[4]";
    private By quantity = By.name("quantity");
    private By totalLbl = By.className("total");


    /**
     * Method to get item names in the cart
     */
    public String getItemNames(int count){
        String itemNames = "";
        for(int i = 1 ; i <= count ; i++){

            //This is to ignore having comma in-front of the first item when concatenating items
            if(i == 1){
                itemNames = getText(By.xpath(itemNameLbl.replace("replace", String.valueOf(i))));
            }else{
                itemNames = itemNames + "," +getText(By.xpath(itemNameLbl.replace("replace", String.valueOf(i))));
            }
        }
        return itemNames;
    }

    /**
     * Method to get item prices in the cart
     */
    public String getPrices(int count){
        String prices = "";
        for(int i = 1 ; i <= count ; i++){
            if(i == 1){
                prices = getText(By.xpath(itemPriceLbl.replace("replace", String.valueOf(i))));
            }else{
                prices = prices + "," +getText(By.xpath(itemPriceLbl.replace("replace", String.valueOf(i))));
            }
        }
        return prices;
    }

    /**
     * Method to get item subTotal in the cart
     */
    public String getSubTotals(int count){
        String totals = "";
        for(int i = 1 ; i <= count ; i++){
            if(i == 1){
                totals = getText(By.xpath(itemSubTotalLbl.replace("replace", String.valueOf(i))));
            }else{
                totals = totals + "," +getText(By.xpath(itemSubTotalLbl.replace("replace", String.valueOf(i))));
            }
        }
        return totals;
    }

    /**
     * Method to get item total in the cart
     */
    public String getTotal(){
        return getText(totalLbl);
    }


    /**
     * Method to get number of items in the cart
     */
    public int getNumberOfItems(){
        return getNumberOfElements(quantity);
    }
}
