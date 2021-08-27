package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/Report/report.html"},
        tags="@H1",
        publish = false,
        dryRun = false
)
public class TestRunner {
}
