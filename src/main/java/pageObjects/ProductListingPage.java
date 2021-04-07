package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class ProductListingPage extends Base {
    private By productList = By.xpath("//div[@data-hook='homepage_products']");
    private By noProductsFoundHeader = By.className("plp-not-found-header");
    private By noProductsFoundText = By.className("plp-not-found-text");

    public WebElement getProductList(){
        return driver.findElement(productList);
    }

    public WebElement getNoProductsFoundHeader(){
        return driver.findElement(noProductsFoundHeader);
    }

    public WebElement getNoProductsFoundText(){
        return driver.findElement(noProductsFoundText);
    }
}
