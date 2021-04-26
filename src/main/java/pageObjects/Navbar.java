package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;
import resources.Utilities;

public class Navbar extends Base {
    private By accountIcon = By.cssSelector("#account-button");
    private By signUp = By.cssSelector("a[href*=signup]");
    private By login = By.cssSelector("a[href*=login]");
    private By logout = By.cssSelector("a[href*=logout]");
    private By searchIcon = By.className("search-icons");
    private By keywords = By.id("keywords");
    private By cart = By.className("cart-icon");

    public WebElement getAccountIcon(){
        return driver.findElement(accountIcon);
    }

    public WebElement getLogout() {
        return driver.findElement(logout);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getSignUp(){
        return driver.findElement(signUp);
    }

    public WebElement getSearchIcon(){
        return driver.findElement(searchIcon);
    }

    public WebElement getKeywords(){
        return driver.findElement(keywords);
    }

    public WebElement getCart(){
        Utilities.explicitlyWaitForClickable(driver.findElement(cart));
        return driver.findElement(cart);
    }
}
