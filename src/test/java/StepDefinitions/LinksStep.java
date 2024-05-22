package StepDefinitions;

import DriverFactory.Driver;
import Pages.BasePage;
import io.cucumber.java.en.Then;
import okhttp3.HttpUrl;
import org.openqa.selenium.WebDriver;

public class LinksStep {
    BasePage page = new BasePage(Driver.getDriver());

    @Then("user determines the number of active links in the page")
    public void numberOfActiveLinks() {
        page.getActiveLinksCount();
    }

    @Then("prints the name of the active links")
    public void printLinkName() {
        page.printLinkName();
    }

}
