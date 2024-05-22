package Pages;

import TimeUtility.TimeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {
    //static Logger logger =LogManager.getLogger(BasePage.class) ;

    private WebDriver driver;

    Integer countOfLinks = 0;
    List<String> activelinks;

    private By carOptions = By.xpath("//label[@for='cars']//following::select[@id='cars']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TimeUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


    }
    public static Logger logger() {
        String declaringClass = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(declaringClass);
    }


    public void selectBy(By locator, String type, String value) {
        Select select = new Select(getElement(locator));
        switch (type) {
            case "value":
                select.selectByValue(value);
            case "index":
                select.selectByIndex(Integer.parseInt(value));
            case "visibleText":
                select.selectByVisibleText(value);
        }
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void getDropdownItems(By locator, List<String> actualOptions) {
        Select selectItems = new Select(getElement(locator));
        List<WebElement> optionList = selectItems.getOptions();
        List<String> option = new ArrayList<String>();
        for (WebElement el : optionList) {
            option.add(el.getText());
        }
        Assert.assertEquals(option, actualOptions);
    }

    public void selectOption(By locator, String optionToBeSelected) {
        List<WebElement> optionsList = driver.findElements(locator);
        for (WebElement el : optionsList) {
            String options = el.getText();
            if (options.equalsIgnoreCase(optionToBeSelected)) {
                el.click();
            }
        }
    }

    public void getTableColumnNames(By locator, List<String> columnHeadersexpected) {
        List<WebElement> columnNamesHeaderElement = driver.findElements(locator);
        List<String> columnHeader = new ArrayList<String>();
        for (WebElement el : columnNamesHeaderElement) {
            columnHeader.add(el.getText());
        }
        Assert.assertEquals(columnHeadersexpected, columnHeader);

    }

    public void getActiveLinksCount() {
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        List<WebElement> activelinks = new ArrayList<WebElement>();
        for (WebElement links : linksList) {
            if (links.getAttribute("href") != null) {
                activelinks.add(links);
                countOfLinks = activelinks.size();
            }
        }
      logger().info("The number of active links  :" + countOfLinks);

    }

    public void printLinkName() {
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        activelinks = new ArrayList<>();
        for (WebElement links : linksList) {
            if (links.getAttribute("href") != null) {
                activelinks.add(links.getAttribute("href"));
                logger().info("The active links are" + activelinks);
            }
        }

    }

}
