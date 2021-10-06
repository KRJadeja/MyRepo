package StepDefinitions;

import com.saucelabs.junit.SauceOnDemandTestWatcher;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.*;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.saucerest.SauceREST;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
//import org.openqa.selenium.remote.SessionId;
//import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;


import java.net.MalformedURLException;
import java.net.URL;

//public class CommonSteps implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {
 public class CommonSteps implements SauceOnDemandSessionIdProvider {
//public class CommonSteps {
    //private WebDriver driver;
    //Scenario scenario;

    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY =System.getenv("SAUCE_ACCESS_KEY");
    public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME,ACCESS_KEY);
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final ThreadLocal<String> sessionId = new ThreadLocal<String>();

    public String jobName;
    String id;

    @Before(order = 0)
    private void getScenarioName(Scenario scenario) {
        jobName = scenario.getName();
    }

    @Before
    private void setUp() throws MalformedURLException {
        //To Run on Saucelabs
        ChromeOptions options = new ChromeOptions();
        options.setCapability("version", "latest");
        options.setCapability("platform","Windows 10");
        options.setCapability("name",jobName);
        options.setCapability("build","kiran");

        //driver = new RemoteWebDriver(new URL(URL), options);
        driver.set(new RemoteWebDriver(new URL(URL), options));

        //id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        sessionId.set(((RemoteWebDriver) getDriver()).getSessionId().toString());

        System.out.println("Session ID : "+getSessionId());

        //return driver;
    }

    public WebDriver getDriver()
    {
        return driver.get();
        //return driver;
    }
    @After
    public void tierDown()
    {
        // id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        //sessionId.set(id);
        //driver.quit();
        //webDriver.get().quit();
        driver.get().quit();
    }
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this,authentication);

    @Override
    public String getSessionId() {

        return sessionId.get();
    }
    public SauceOnDemandAuthentication getAuthentication() {

        return authentication;
    }
}