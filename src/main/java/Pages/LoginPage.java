package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private By userEmail = By.xpath("//label[normalize-space()='User Email']//parent::div[contains(@class,'userform')]//input[@placeholder='Enter email']");private By password = By.xpath("//label[normalize-space()='Password']//parent::div[contains(@class,'userform')]//input[@id='pass']");
    private By company = By.xpath("(//label[normalize-space()='Company']//..//..//input[@name='company'])[1]");
    private By mobileNumber = By.xpath("(//label[normalize-space()='Mobile Number']//..//..//input[@name='mobile number'])[1]");
    private By submit = By.xpath("//button[normalize-space(text())='Submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);


    }

    public void urlDetails() {
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    public String pageTitles() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String pageTabTitle() {
        String pageTab = driver.getCurrentUrl();
        return pageTab;
    }

    public void loginDetails() {
        WebElement email = driver.findElement(userEmail);
        email.sendKeys("abc@gmail.com");
        WebElement loginPassword = driver.findElement(password);
        email.sendKeys("abc");
        WebElement companyName = driver.findElement(company);
        companyName.sendKeys("XYZ");
        WebElement mobileNos = driver.findElement(mobileNumber);
        mobileNos.sendKeys("23456718");

    }

    public void submitBtnclick() {
        WebElement submitBtn = driver.findElement(submit);
        submitBtn.click();
    }
}
