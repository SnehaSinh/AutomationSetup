package StepDefinitions;

import DriverFactory.Driver;
import Pages.BasePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(Driver.getDriver());

    @Given("user enters the url")
    public void enterUrl() throws InterruptedException {
        loginPage.urlDetails();
    }

    @When("verifies the title of the page")
    public void verifyTitle() {
        Assert.assertEquals(loginPage.pageTitles(), "Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios.");
        //Assert.assertTrue(loginPage.pageTitles().contains("Xpath Practice Page"));
    }

    @When("the current tab as {string}")
    public void verifyCurrentTab(String titlecontent) {
        Assert.assertTrue(loginPage.pageTabTitle().contains(titlecontent));
    }

    @When("the user enters the login information")
    public void verifyLoginDetails() throws InterruptedException {
        loginPage.loginDetails();
    }

    @Then("clicks on submit")
    public void clickSubmit() {
        loginPage.submitBtnclick();
    }

    @Given("the user clicks on car dropdown")
    public void clickFOrDropdown() throws InterruptedException {
        loginPage.clickForOptions();
    }

    @Then("verify below options are present in the dropdown list")
    public void verifydropdownlistNames(DataTable tables) {

        loginPage.verifydropdownlist(tables);
    }

    @Then("user selects {string} and verifies the selection")
    public void verifySelection(String carName) {
        loginPage.selectCarOption(carName);
    }

    @Given("the user verifies the table name is {string}")
    public void tablename(String name) {
        Assert.assertEquals(loginPage.tableName(), name);
    }

    @Then("the user validates that the table contains below mentioned columns")
    public void tableColumns(DataTable dataTable) {
        loginPage.verifyColumnNames(dataTable);
    }

    @Then("verifies the count of entries in the {string} is {int}")
    public void countOfEntries(String string, Integer numberOfUsers) {
        Assert.assertEquals(loginPage.getNoOfUsers(), numberOfUsers);
    }

    @Then("the user selects checkbox against {string} user from the table")
    public void the_user_selects_checkbox_against_user_from_the_table(String string) throws InterruptedException {
        loginPage.clickCheckBox();
    }

    @Then("verifies the user is selected")
    public void verifies_the_user_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("enters the name of the user in the user name field")
    public void entersSelectedUser() {

    }

    @When("the user clicks on the {string} and verify the message of the alert is {string}")
    public void the_user_clicks_on_the(String field, String alertmsg) throws InterruptedException {
        Assert.assertEquals(loginPage.clickOnAlertButton(field), alertmsg);
        loginPage.acceptAlert();
    }

    @And("then accepts the alert")
    public void acceptAlert() {
        loginPage.acceptAlert();
    }

    @Then("user clicks on the {string} and enters the message {string}")
    public void the_user_accepts_the_alert(String field, String text) throws InterruptedException {
        loginPage.clickOnPromptAlert(field, text);
    }


    @Then("user enters {string} and {string}")
    public void userNamePassword(String username, String password) {
        loginPage.userNamePassword(username, password);
    }

    @Then("then enters {string} and {int}")
    public void companyMobile(String companyName, Integer mobileNumber) {
        loginPage.companyMobileDetails(companyName, mobileNumber);
    }

}


