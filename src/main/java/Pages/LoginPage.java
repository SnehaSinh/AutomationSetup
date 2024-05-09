package Pages;


import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static TimeUtility.TimeUtil.EXPLICIT_WAIT_FOR_ALERT_TO_BE_PRESENT;


public class LoginPage extends BasePage {

    private WebDriver driver;
    private By userEmail = By.xpath("//label[normalize-space()='User Email']//parent::div[contains(@class,'userform')]//input[@placeholder='Enter email']");
    private By password = By.xpath("//label[normalize-space()='Password']//parent::div[contains(@class,'userform')]//input[@id='pass']");
    private By company = By.xpath("(//label[normalize-space()='Company']//..//..//input[@name='company'])[1]");
    private By mobileNumber = By.xpath("(//label[normalize-space()='Mobile Number']//..//..//input[@name='mobile number'])[1]");
    private By submit = By.xpath("//button[normalize-space(text())='Submit']");
    private By carOptions = By.xpath("//label[@for='cars']//following::select[@id='cars']");
    private By carOptionSelect = By.xpath("//label[@for='cars']//following::select[@id='cars']//option");
    private By tableName = By.xpath("//h3[normalize-space(text())='Users Table']");
    private By columNames = By.xpath("//th[@class='header']//a");
    private By users = By.xpath("//td[@class='left']//a");
    private By adminUserCheckbox = By.xpath("//td[text()='Admin']//..//td//input[@type='checkbox']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void urlDetails() {
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    public String pageTitles() {
        return driver.getTitle();
    }

    public String pageTabTitle() {
        return driver.getCurrentUrl();

    }

    public void loginDetails() throws InterruptedException {
        WebElement email = driver.findElement(userEmail);
        email.sendKeys("abc@gmail.com");
        WebElement loginPassword = driver.findElement(password);
        loginPassword.sendKeys("abc");
        WebElement companyName = driver.findElement(company);
        companyName.sendKeys("XYZ");
        WebElement mobileNos = driver.findElement(mobileNumber);
        mobileNos.sendKeys("23456718");
        Thread.sleep(2000);

    }

    public void submitBtnclick() {
        WebElement submitBtn = driver.findElement(submit);
        submitBtn.click();
    }

    public void verifydropdownlist(DataTable dataTable) {
        List<String> options = dataTable.cells().get(0);
        getDropdownItems(carOptions, options);

    }

    public void clickForOptions() throws InterruptedException {
        WebElement OptionsList = driver.findElement(carOptions);
        OptionsList.click();
        Thread.sleep(4000);

    }

    public void selectCarOption(String carName) {
        selectOption(carOptionSelect, carName);
    }

    public String tableName() {
        WebElement header = driver.findElement(tableName);
        return header.getText();
    }

    public void verifyColumnNames(DataTable table) {
        List<String> columnNamesExp = table.cells().get(0);
        getTableColumnNames(columNames, columnNamesExp);

    }

    public Integer getNoOfUsers() {
        List<WebElement> numberOfUsers = driver.findElements(users);
        return numberOfUsers.size();
    }

    public void clickCheckBox() throws InterruptedException {
        WebElement adminCheckBox = driver.findElement(adminUserCheckbox);
        if (!adminCheckBox.isSelected()) {
            adminCheckBox.click();
            Thread.sleep(2000);
        }
    }

    public String clickOnAlertButton(String field) throws InterruptedException {
        WebElement alertButtonText = driver.findElement(By.xpath("//button[text()='Click To Open " + field + "']"));
        alertButtonText.click();
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_FOR_ALERT_TO_BE_PRESENT);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();

    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void clickOnPromptAlert(String field,String text) throws InterruptedException {
        WebElement alertButtonText = driver.findElement(By.xpath("//button[text()='Click To Open " + field + "']"));
        alertButtonText.click();
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_FOR_ALERT_TO_BE_PRESENT);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);

    }
    public void userNamePassword(String userName,String passwordName){
        WebElement userNameElement= driver.findElement(userEmail);
        userNameElement.sendKeys(userName);
        WebElement userPasswordElement=driver.findElement(password);
        userPasswordElement.sendKeys(passwordName);
    }
    public void companyMobileDetails(String companyName,Integer mobile){
        WebElement userNameElement= driver.findElement(company);
        userNameElement.sendKeys(companyName);
        WebElement userPasswordElement=driver.findElement(mobileNumber);
        userPasswordElement.sendKeys(String.valueOf(mobile));
    }
}

