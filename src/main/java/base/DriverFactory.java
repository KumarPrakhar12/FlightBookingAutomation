package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

public static WebDriver initDriver(String browser){

if(browser.equalsIgnoreCase("chrome")){

WebDriverManager.chromedriver().setup();
driver.set(new ChromeDriver());

}

else if(browser.equalsIgnoreCase("firefox")){

WebDriverManager.firefoxdriver().setup();
driver.set(new FirefoxDriver());

}

else{

System.out.println("Invalid browser name. Launching Chrome by default.");

WebDriverManager.chromedriver().setup();
driver.set(new ChromeDriver());

}

driver.get().manage().window().maximize();

return driver.get();

}

public static WebDriver getDriver(){

return driver.get();

}

}