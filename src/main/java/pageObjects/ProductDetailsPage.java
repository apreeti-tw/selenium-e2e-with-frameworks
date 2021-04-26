package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class ProductDetailsPage extends Base {
    private By sizeOptions = By.xpath("//input[contains(@id,'variant_option_value_id_')]//following-sibling::label/span");
    private By addToCartButton = By.id("add-to-cart-button");
    private By productAddedModal = By.className("product-added-modal-message");

    public WebElement getSizeOptions(String option){
        for (WebElement el:driver.findElements(sizeOptions)) {
            if(el.getText().equals(option))
                return el;
        }
        return null;
    }

    public WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }

    public WebElement getProductAddedModal(){
        return driver.findElement(productAddedModal);
    }

}
