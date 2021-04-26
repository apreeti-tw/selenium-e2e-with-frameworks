package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

import java.util.List;

public class ProductDetailsPage extends Base {
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({@FindBy(xpath = "//input[contains(@id,'variant_option_value_id_')]//following-sibling::label/span")})
    private List<WebElement> sizeOptions;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(className = "product-added-modal-message")
    private WebElement productAddedModal;

    public WebElement getSizeOptions(String option){
        for (WebElement el:sizeOptions) {
            if(el.getText().equals(option))
                return el;
        }
        return null;
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    public WebElement getProductAddedModal(){
        return productAddedModal;
    }

}
