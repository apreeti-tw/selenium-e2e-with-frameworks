package factory;

import factory.enums.BrowserOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private DriverFactory(){}

    private static final Supplier<WebDriver> CHROME = () -> {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    };

    private static final Supplier<WebDriver> CHROME_LOCAL = () -> {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
        return new ChromeDriver();
    };

    private static final Map<BrowserOptions, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserOptions.class);

    static {
        MAP.put(BrowserOptions.CHROME, CHROME);
        MAP.put(BrowserOptions.CHROME_LOCAL, CHROME_LOCAL);
    }

    public static WebDriver getDriver(BrowserOptions browser){
        return MAP.get(browser).get();
    }
}
