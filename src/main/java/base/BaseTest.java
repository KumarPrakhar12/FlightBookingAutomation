package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        System.out.println("Launching browser: " + browser);

        driver = DriverFactory.initDriver(browser);

        driver.get("https://blazedemo.com");

        ScreenshotUtil.captureScreenshot(driver, "Application_Launched");
        //This calls a utility class.
        //
    }

    @AfterMethod
    public void tearDown() {
    	System.out.println("New Change");

        DriverFactory.quitDriver();
    }
}