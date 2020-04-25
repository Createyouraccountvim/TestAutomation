package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void instantiateWebDriverFirefox() {
        setWebDriver(new FirefoxDriver(setFirefoxOptions()));
        BaseDriver.getDriver().manage().window().maximize();
    }

    public static void instantiateWebDriver() {
        setWebDriver(new ChromeDriver(setChromeOptions()));
    }

    public static void quitDriver() {
        webDriver.get().quit();
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    private static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    private static ChromeOptions setChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability("chrome.switches", Collections.singletonList("--incognito"));
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return options;
    }

    private static FirefoxOptions setFirefoxOptions() {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        FirefoxOptions opt = new FirefoxOptions();
        return opt;
    }
}
