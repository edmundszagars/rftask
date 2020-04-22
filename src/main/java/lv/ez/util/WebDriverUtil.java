package lv.ez.util;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

    private static WebDriver webDriver;
    private static WebDriverWait wait;
    protected static PropertyReader propertyReader = new PropertyReader();


    public WebDriverUtil() {
        if (webDriver == null) {
            setupDriver();
            webDriver.manage().window().maximize();
            wait = new WebDriverWait(webDriver, propertyReader.getWaitTime());
        }
    }

    private void setupDriver() {
        String selectedDriver = propertyReader.getSelectedDriver();
        switch (selectedDriver) {
            case "firefox":
                WebDriverManager.firefoxdriver().forceDownload().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("autoGrantPermissions", "true");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case "opera":
                WebDriverManager.operadriver().forceDownload().setup();
                webDriver = new OperaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
        }

    }

    public static void close() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
            webDriver.close();
            webDriver.quit();
        }
    }

    public static void scrollTo(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static void hover(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).build().perform();
    }

    public static WebDriver getCurrentDriver() {
        return webDriver;
    }

    public static WebDriverWait driverWait() {
        return wait;
    }
}
