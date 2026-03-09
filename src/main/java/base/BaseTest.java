package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){

        driver = DriverFactory.initDriver(browser);

        driver.get("https://blazedemo.com");

        ScreenshotUtil.captureScreenshot(driver,"Application_Launched");

    }

    @AfterMethod
    public void tearDown(){

        DriverFactory.getDriver().quit();

    }

}