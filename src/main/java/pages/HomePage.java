package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

import utils.ScreenshotUtil;

public class HomePage {

WebDriver driver;

public HomePage(WebDriver driver){

this.driver=driver;

}

By departureCity=By.name("fromPort");
By destinationCity=By.name("toPort");
By findFlightsBtn=By.cssSelector("input[type='submit']");

public void selectCities(String from,String to){

Select fromDropdown=new Select(driver.findElement(departureCity));
fromDropdown.selectByVisibleText(from);
WaitUtils.pause(2);

Select toDropdown=new Select(driver.findElement(destinationCity));
toDropdown.selectByVisibleText(to);
WaitUtils.pause(2);

String path = ScreenshotUtil.captureScreenshot(driver,"Cities_Selected");

listeners.TestListener.test.get().info("Cities Selected")
.addScreenCaptureFromPath(path);

}

public void clickFindFlights(){

driver.findElement(findFlightsBtn).click();
WaitUtils.pause(3);
String path = ScreenshotUtil.captureScreenshot(driver,"Flights_Search_Clicked");

listeners.TestListener.test.get().info("Find Flights Clicked")
.addScreenCaptureFromPath(path);

}

}