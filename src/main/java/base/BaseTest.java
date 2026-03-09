package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters; // ADD THIS

import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser") // TAKE BROWSER FROM XML
    public void setup(String browser) {

        // If browser parameter is missing, fallback to system property
        if(browser == null || browser.isEmpty()){
            browser = System.getProperty("browser");
        }

        // Default to Chrome if still null
        if(browser == null || browser.isEmpty()){
            browser = "chrome";
        }

        driver = DriverFactory.initDriver(browser);

        driver.get("https://blazedemo.com");
        ScreenshotUtil.captureScreenshot(driver, "Application_Launched");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}