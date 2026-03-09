package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ScreenshotUtil;
import utils.WaitUtils;

public class FlightsPage {

WebDriver driver;

public FlightsPage(WebDriver driver){

this.driver=driver;

}

By chooseFlight=By.xpath("(//input[@value='Choose This Flight'])[1]");

public void chooseFlight(){

driver.findElement(chooseFlight).click();
WaitUtils.pause(3);
String path = ScreenshotUtil.captureScreenshot(driver,"Flight_Selected");

listeners.TestListener.test.get().info("Flight Selected")
.addScreenCaptureFromPath(path);

}

}