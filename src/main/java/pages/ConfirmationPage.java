package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ScreenshotUtil;
import utils.WaitUtils;

public class ConfirmationPage {

WebDriver driver;

public ConfirmationPage(WebDriver driver){

this.driver=driver;

}

By message=By.tagName("h1");

public String getConfirmationMessage(){
	String path = ScreenshotUtil.captureScreenshot(driver,"Booking_Confirmed");

	listeners.TestListener.test.get().info("Booking Confirmed")
	.addScreenCaptureFromPath(path);
	WaitUtils.pause(2);

return driver.findElement(message).getText();

}

}