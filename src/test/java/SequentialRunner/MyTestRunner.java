package SequentialRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"StepDefinitions", "ApplicationHooks"},
        plugin = {"pretty", "html:target/cucumber-report.html","rerun:target/rerun/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false
        //tags = "@Test"


)

public class MyTestRunner {

}
