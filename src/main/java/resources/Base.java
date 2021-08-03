package resources;

import factory.enums.BrowserOptions;
import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver initialiseDriver() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/application_test.properties"));
        driver = DriverFactory.getDriver(BrowserOptions.CHROME_LOCAL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/reports/"+testName+".png"));
        return testName+".png";
    }
}
