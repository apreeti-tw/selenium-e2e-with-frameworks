import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Navbar;
import pageObjects.RegisterUserAndLoginPage;
import resources.Base;
import resources.Utilities;

import java.io.IOException;

public class FailExampleTest extends Base {
    public WebDriver driver;
    private Navbar navbar;
    private RegisterUserAndLoginPage registerUserAndLoginPage;

    @BeforeTest
    public void setDriver() throws IOException {
        this.driver = initialiseDriver();
        this.driver.get(properties.getProperty("base_url"));
        navbar = new Navbar();
        registerUserAndLoginPage = new RegisterUserAndLoginPage();
    }

    @Test
    public void failExampleScreenshotTest(){
        navbar.getAccountIcon().click();
        navbar.getLogin().click();

        registerUserAndLoginPage.getEmail().sendKeys("test2@valid.com");
        registerUserAndLoginPage.getPassword().sendKeys("password");
        registerUserAndLoginPage.getLogin().click();

        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Logged in successfully"));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
    }

    @AfterTest
    public void tearDown(){
        this.driver.close();
        this.driver.quit();
    }
}
