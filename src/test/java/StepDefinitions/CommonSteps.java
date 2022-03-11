package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.saucelabs.saucerest.SauceREST;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import java.net.MalformedURLException;
import java.net.URL;

 public class CommonSteps implements SauceOnDemandSessionIdProvider {

    public String USERNAME = System.getenv("SAUCE_USERNAME");
    public String ACCESS_KEY =System.getenv("SAUCE_ACCESS_KEY");
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME,ACCESS_KEY);
    //public final String URL = "https://"+ authentication.getUsername()+":"+authentication.getAccessKey()+"@ondemand.saucelabs.com:443/wd/hub";
    public final String URLS = "https://"+ authentication.getUsername()+":"+authentication.getAccessKey()+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public final String BUILD = System.getenv("JENKINS_BUILD_NUMBER");


    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();
    public String jobName;
    public static boolean testResults;

    @Before(order = 0)
    public void getScenarioName(Scenario scenario) {
        jobName = scenario.getName();
        testResults = false;
    }
    @Before
    public void setUp() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("version", "latest");
        options.setCapability("platform", "Windows 10");
        options.setCapability("name", jobName);
        options.setCapability("build",BUILD);

        driver.set(new RemoteWebDriver(new URL(URLS), options));
        sessionId.set(((RemoteWebDriver) getDriver()).getSessionId().toString());

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",sessionId.get(),jobName);
        System.out.println(message);

    }
    public WebDriver getDriver()
    {
        return driver.get();
    }
    @After()
    public void tierDown()
    {
        driver.get().quit();
        UpdateResults(testResults);
    }

    @Override
    public String getSessionId() {
        return sessionId.get();
    }

    public void UpdateResults(boolean testResults)
    {
        SauceREST saucerest = new SauceREST(USERNAME,ACCESS_KEY);
        Map<String,Object> updates = new HashMap<String,Object>();
        updates.put("passed", testResults);
        saucerest.updateJobInfo(getSessionId(),updates);
    }
}