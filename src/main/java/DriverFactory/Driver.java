package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    Logger logger = LogManager.getLogger(Driver.class);

    public WebDriver init_driver(String browser) {
        logger.info("****************Launching " + browser + " **********************");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver(chromeOptions));

        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
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


