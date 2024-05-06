package StepDefinitions;

import DriverFactory.Driver;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(Driver.getDriver());

    @Given("user enters the url")
    public void enterUrl() throws InterruptedException {
        loginPage.urlDetails();
    }


    @When("verifies the title of the page")
    public void verifyTitle() {
        Assert.assertEquals(loginPage.pageTitles(),"Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios.");
        //Assert.assertTrue(loginPage.pageTitles().contains("Xpath Practice Page"));
    }

    @When("the current tab as {string}")
    public void verifyCurrentTab(String titlecontent) {
        Assert.assertTrue(loginPage.pageTabTitle().contains(titlecontent));
    }

    @When("the user enters the login information")
    public void verifyLoginDetails() {
        loginPage.loginDetails();
    }

    @Then("clicks on submit")
    public void clickSubmit() {
loginPage.submitBtnclick();
    }
}


