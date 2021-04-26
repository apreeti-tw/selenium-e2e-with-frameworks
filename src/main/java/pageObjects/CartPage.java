package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class CartPage extends Base {
    private By cartTotal = By.className("shopping-cart-total-amount");

    public WebElement getCartTotal(){
        return driver.findElement(cartTotal);
    }
}
