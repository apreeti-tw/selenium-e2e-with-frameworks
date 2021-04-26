package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class CartPage extends Base {
    private By cartTotal = By.className("shopping-cart-total-amount");
    private By productNames = By.className("item-title");

    public WebElement getCartTotal(){
        return driver.findElement(cartTotal);
    }

    public boolean listProductByName(String productName){
        for(WebElement el: driver.findElements(productNames)){
            if(el.getText().equals(productName))
                return true;
        }
        return false;
    }
}
