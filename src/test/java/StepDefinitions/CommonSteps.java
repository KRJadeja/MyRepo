package StepDefinitions;

import com.saucelabs.junit.SauceOnDemandTestWatcher;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.saucelabs.saucerest.SauceREST;
import com.saucelabs.saucerest.DataCenter;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.remote.SessionId;
//import org.openqa.selenium.remote.SessionId;
//import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;


import java.net.MalformedURLException;
import java.net.URL;

//public class CommonSteps implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {
 public class CommonSteps implements SauceOnDemandSessionIdProvider {
//public class CommonSteps {

    public String USERNAME = System.getenv("SAUCE_USERNAME");
    public String ACCESS_KEY =System.getenv("SAUCE_ACCESS_KEY");
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME,ACCESS_KEY);
    public final String URL = "https://"+ authentication.getUsername()+":"+authentication.getAccessKey()+"@ondemand.saucelabs.com:443/wd/hub";
    public final String BUILD = System.getenv("JENKINS_BUILD_NUMBER");
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();
    //private WebDriver driver;
    //Scenario scenario;
    public String jobName;
    public static boolean testResults;
    String id;
    private SauceREST sauceClient;
    private String jobInfo;

    @Before(order = 0)
    public void getScenarioName(Scenario scenario) {
        jobName = scenario.getName();
        testResults = false;
    }
    /*@Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }*/
    @Before
    public void setUp() throws MalformedURLException {
        //To Run on Saucelabs
        ChromeOptions options = new ChromeOptions();
        options.setCapability("version", "latest");
        options.setCapability("platform","Windows 10");
        options.setCapability("screenResolution","1440x900");
        options.setCapability("name",jobName);
        options.setCapability("build",BUILD);

        //driver = new RemoteWebDriver(new URL(URL), options);
        driver.set(new RemoteWebDriver(new URL(URL), options));

        //id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        sessionId.set(((RemoteWebDriver) getDriver()).getSessionId().toString());
        //System.out.println("Session ID : "+getSessionId());
        //sauceClient = new SauceREST(USERNAME,ACCESS_KEY,DataCenter.US);

    }
    public WebDriver getDriver()
    {
        return driver.get();
    }
    @After()
    public void tierDown()
    {
        //testResults =true;
        UpdateResults(testResults);
       // UpdateResults();
        driver.get().quit();
    }

    @Override
    public String getSessionId() {
        return sessionId.get();
    }
    public @Rule
    SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this::getSessionId, getAuthentication());
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }
    /*@Rule public TestName name = new TestName(){
        @Override
        public String getMethodName() {
            return super.getMethodName();
        }
    };*/
    public void UpdateResults(boolean testResults)
    {
        SauceREST saucerest = new SauceREST(USERNAME,ACCESS_KEY);
        Map<String,Object> updates = new HashMap<String,Object>();
        //saucerest.jobPassed(sessionId.get());
       // saucerest.jobFailed(sessionId.get());
        //jobInfo = saucerest.getJobInfo(sessionId.get());
        //System.out.println("Info "+  updates.get("passed"));
        updates.put("passed", testResults);
        saucerest.updateJobInfo(getSessionId(),updates);
    }
}