package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;
import utils.ScreenshotUtil;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By departureCity = By.name("fromPort");
    By destinationCity = By.name("toPort");
    By findFlightsBtn = By.cssSelector("input[type='submit']");

    public void selectCities(String from, String to){
        
        WaitUtils.waitForElement(driver, departureCity);
        Select fromDropdown = new Select(driver.findElement(departureCity));
        fromDropdown.selectByVisibleText(from);

     
        WaitUtils.waitForElement(driver, destinationCity);
        Select toDropdown = new Select(driver.findElement(destinationCity));
        toDropdown.selectByVisibleText(to);

       
        String path = ScreenshotUtil.captureScreenshot(driver, "Cities_Selected");
        listeners.TestListener.test.get().info("Cities Selected")
                .addScreenCaptureFromPath(path);
    }

    public void clickFindFlights(){
       
        WaitUtils.waitForElement(driver, findFlightsBtn);
        driver.findElement(findFlightsBtn).click();

      
        String path = ScreenshotUtil.captureScreenshot(driver, "Flights_Search_Clicked");
        listeners.TestListener.test.get().info("Find Flights Clicked")
                .addScreenCaptureFromPath(path);

        WaitUtils.pause(1);
    }
}