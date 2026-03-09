package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ScreenshotUtil;

public class BaseTest {

protected WebDriver driver;

@BeforeMethod
public void setup(){

driver = DriverFactory.initDriver();

driver.get("https://blazedemo.com");

ScreenshotUtil.captureScreenshot(driver,"Application_Launched");

}

@AfterMethod
public void tearDown(){

driver.quit();

}

}