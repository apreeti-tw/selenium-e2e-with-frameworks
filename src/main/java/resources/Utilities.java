package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Utilities extends Base{
    private static By successAlert = By.cssSelector(".alert-success");
    private static By dangerAlert = By.cssSelector(".alert-danger");
    private static By modalClose = By.xpath("//button[@class='close']/span");

    public static WebElement getSuccessAlert(){
        return driver.findElement(successAlert);
    }

    public static WebElement getErrorAlert(){
        return driver.findElement(dangerAlert);
    }

    public static int randomNumber(int upperbound){
        return (new Random().nextInt(upperbound));
    }

    public static void closeModal() throws InterruptedException {
        driver.findElement(modalClose).click();
        Thread.sleep(10000);
    }

    public static void explicitlyWaitForClickable(WebElement webElement){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
