import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Navbar;
import pageObjects.ProductListingPage;
import resources.Base;

import java.io.IOException;

public class SearchTests extends Base {
    private WebDriver driver;
    private Navbar navbar;
    private ProductListingPage productListingPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        driver.get(properties.getProperty("base_url"));
        navbar = new Navbar();
        productListingPage = new ProductListingPage();
    }

    @Parameters({"validSearchKeyword"})
    @Test
    public void validSearchTest(String searchKeyword){
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(searchKeyword);
        navbar.getKeywords().sendKeys(Keys.ENTER);

        Assert.assertTrue(productListingPage.getProductList().isDisplayed());
    }

    @Parameters({"invalidSearchKeyword"})
    @Test
    public void invalidSearchTest(String searchKeyword){
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(searchKeyword);
        navbar.getKeywords().sendKeys(Keys.ENTER);

        Assert.assertTrue(productListingPage.getNoProductsFoundHeader().getText().contains("No results found"));
        Assert.assertTrue(productListingPage.getNoProductsFoundText().getText().contains("We couldn’t find products for '"+searchKeyword+"'"));
    }

    @AfterTest
    public void teardown(){
        this.driver.close();
        this.driver.quit();
    }
}
