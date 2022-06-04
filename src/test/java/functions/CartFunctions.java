package functions;

import pages.Cartpage;

public class CartFunctions {
    Cartpage cartpage = new Cartpage();

    /**
     * Method to get Items, available in the cart
     */
    public String getCartItems(){
        return cartpage.getItemNames(cartpage.getNumberOfItems());
    }

    /**
     * Method to get prices of Items, available in the cart
     */
    public String getPricesOfItems(){
        return cartpage.getPrices(cartpage.getNumberOfItems());
    }

    /**
     * Method to get subtotal of Items, available in the cart
     */
    public String getSubTotalOfEachItemType(){
        return cartpage.getSubTotals(cartpage.getNumberOfItems());
    }

    /**
     * Method to get total of Items, available in the cart
     */
    public String getTotal(){
        return cartpage.getTotal();
    }


}
