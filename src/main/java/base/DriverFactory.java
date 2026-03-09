package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            // Headless option for Jenkins
            if(System.getProperty("jenkins") != null) options.addArguments("--headless");
            driver.set(new ChromeDriver(options));
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            // Headless option for Jenkins
            if(System.getProperty("jenkins") != null) options.addArguments("--headless");
            driver.set(new FirefoxDriver(options));
        } 
        else {
            System.out.println("Invalid browser! Launching Chrome by default.");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}