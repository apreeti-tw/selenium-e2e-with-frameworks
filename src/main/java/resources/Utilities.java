package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Utilities extends Base{
    private static By successAlert = By.cssSelector(".alert-success");
    private static By dangerAlert = By.cssSelector(".alert-danger");

    public static WebElement getSuccessAlert(){
        return driver.findElement(successAlert);
    }

    public static WebElement getErrorAlert(){
        return driver.findElement(dangerAlert);
    }

    public static int randomNumber(int upperbound){
        return (new Random().nextInt(upperbound));
    }
}
