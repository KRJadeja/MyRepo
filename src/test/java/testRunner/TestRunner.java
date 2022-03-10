package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {"classpath:NewFeatures/Sample.feature"},
        features = {"src/test/java/Features/EbayHome.feature"},
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/Report/report.html"},
        //plugin = {"pretty", "json:target/Report/report.json"},
        tags="@smoke and @H1",
        publish = false,
        dryRun = false
)
public class TestRunner {
}
