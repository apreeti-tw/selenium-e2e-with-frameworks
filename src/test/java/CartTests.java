import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.Navbar;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListingPage;
import resources.Base;
import resources.Utilities;

import java.io.IOException;

public class CartTests extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        this.driver.get(properties.getProperty("base_url"));
        navbar = new Navbar();
        productListingPage = new ProductListingPage();
        productDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
    }

    @Test
    public void addToCartTest(){
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys("dotted shirt");
        navbar.getKeywords().sendKeys(Keys.ENTER);

        productListingPage.getProductNames().get(0).click();
        productDetailsPage.getSizeOptions("XS").click();
        productDetailsPage.getAddToCartButton().click();

        Utilities.closeModal();
        navbar.getCart().click();

        Assert.assertTrue(cartPage.getCartTotal().getText().contains("74.99"));
    }

    @DataProvider(name = "productList")
    public Object[][] getProductList(){
        Object[][] data = new Object[5][5];
        return data;
    }

    @AfterTest
    public void teardown(){
        this.driver.close();
    }
}
