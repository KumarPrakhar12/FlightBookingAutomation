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

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (browser.equalsIgnoreCase("chrome")) {

            System.out.println("Starting Chrome Browser");

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            driver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            System.out.println("Starting Firefox Browser");

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (headless) {
                options.addArguments("--headless");
            }

            driver.set(new FirefoxDriver(options));

            driver.get().manage().window().maximize();
        }

        else {

            System.out.println("Invalid browser. Launching Chrome by default.");

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}