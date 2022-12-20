package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {"classpath:NewFeatures/Sample.feature"},
        features = {"src/test/java/Features/EbayHome.feature"},
        glue = "StepDefinitions",
        //plugin = {"pretty", "html:target/Report/report.html","StepDefinitions.BaseClass"},
        plugin = {"pretty", "json:target/cucumber.json","html:target/Report/cucumber.html","junit:target/cucumber-results.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@e1 or @e2",
        publish = false,
        dryRun = false
)
public class TestRunner {
}
