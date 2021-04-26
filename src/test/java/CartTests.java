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
        cartPage = new CartPage(driver);
    }

    @Test(dataProvider = "productList")
    public void addToCartTest(String productName, String productPrice, String productSize) throws InterruptedException {
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(productName);
        navbar.getKeywords().sendKeys(Keys.ENTER);

        productListingPage.getProductNames().get(0).click();
        productDetailsPage.getSizeOptions(productSize).click();
        productDetailsPage.getAddToCartButton().click();

        Utilities.closeModal(driver);
        navbar.getCart().click();

        Assert.assertTrue(cartPage.listProductByName(productName));
    }

    @DataProvider(name = "productList")
    public Object[][] getProductList(){
        Object[][] data = { {"Asymetric Coat", "79.99", "XS"},
                            {"Pleated Sleeve V Neck Shirt", "40.99", "M"},
                            {"Anorak With Hood", "99.99", "L"}};
        return data;
    }

    @AfterTest
    public void teardown(){
        this.driver.close();
    }
}
