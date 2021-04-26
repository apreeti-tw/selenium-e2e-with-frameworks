package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

import java.util.List;

public class CartPage extends Base {
    private WebDriver driver;

    public CartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping-cart-total-amount")
    private WebElement cartTotal;

    @FindAll({@FindBy(className = "item-title")})
    private List<WebElement> productNames;

    public WebElement getCartTotal(){
        return cartTotal;
    }

    public boolean listProductByName(String productName){
        for(WebElement el: productNames){
            if(el.getText().equals(productName))
                return true;
        }
        return false;
    }
}
