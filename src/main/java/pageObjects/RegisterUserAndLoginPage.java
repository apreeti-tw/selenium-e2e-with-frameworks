package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class RegisterUserAndLoginPage extends Base {
    private By email = By.cssSelector("#spree_user_email");
    private By password = By.cssSelector("#spree_user_password");
    private By confirmPassword = By.cssSelector("#spree_user_password_confirmation");
    private By signUp = By.name("commit");
    private By login = By.name("commit");

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getConfirmPassword(){
        return driver.findElement(confirmPassword);
    }

    public WebElement getSignUp(){
        return driver.findElement(signUp);
    }

    public WebElement getLogin() {
        return driver.findElement(signUp);
    }
}
