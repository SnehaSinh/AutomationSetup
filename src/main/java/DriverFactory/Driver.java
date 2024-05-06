package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println("The browser being used is: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
           // chromeOptions.set
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver(chromeOptions));
        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver(firefoxOptions));


        } else {
            System.out.println(" The browser " + browser + "is different from what is configured");
        }

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();

    }
}


