package testBase;

import driver.BaseDriver;
import org.testng.annotations.*;

public class BaseTest {
    public BaseTest() {
    }

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            BaseDriver.instantiateWebDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            BaseDriver.instantiateWebDriverFirefox();
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        BaseDriver.quitDriver();
    }
}