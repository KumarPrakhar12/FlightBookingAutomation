package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ScreenshotUtil;
import utils.WaitUtils;

public class PurchasePage {

WebDriver driver;

public PurchasePage(WebDriver driver){

this.driver=driver;

}

By name=By.id("inputName");
By address=By.id("address");
By city=By.id("city");
By state=By.id("state");
By zip=By.id("zipCode");

By cardNumber=By.id("creditCardNumber");
By purchaseBtn=By.cssSelector("input[type='submit']");

public void enterDetails(String userName,String userAddress,String userCity,String card){

driver.findElement(name).sendKeys(userName);
WaitUtils.pause(1);
driver.findElement(address).sendKeys(userAddress);
WaitUtils.pause(1);
driver.findElement(city).sendKeys(userCity);
WaitUtils.pause(1);
driver.findElement(state).sendKeys("NY");
WaitUtils.pause(1);
driver.findElement(zip).sendKeys("10001");
WaitUtils.pause(1);
driver.findElement(cardNumber).sendKeys(card);
WaitUtils.pause(1);
String path = ScreenshotUtil.captureScreenshot(driver,"Passenger_Details_Entered");

listeners.TestListener.test.get().info("Passenger Details Entered")
.addScreenCaptureFromPath(path);

}

public void purchase(){

driver.findElement(purchaseBtn).click();
String path = ScreenshotUtil.captureScreenshot(driver,"Purchase_Page_Loaded");

listeners.TestListener.test.get().info("Purchase Button Clicked")
.addScreenCaptureFromPath(path);
}

}
