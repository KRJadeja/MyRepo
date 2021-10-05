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
    private WebDriver driver;
    Scenario scenario;

    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY =System.getenv("SAUCE_ACCESS_KEY");
    public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USERNAME,ACCESS_KEY);
    private final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private final ThreadLocal<String> sessionId = new ThreadLocal<String>();

    public String jobName;
    String id;

    @Before(order = 0)
    public void getScenarioName(Scenario scenario) {
        jobName = scenario.getName();
       // System.out.println("Sessionid "+ sessionId);
       // System.out.println("Authentication "+ authentication);
    }

    @Before
    public WebDriver getDriver() throws MalformedURLException {
        //To Run on Local
       /*System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();*/

        //To Run WebDriverManager
        //ChromeOptions chromeOptions = new ChromeOptions();
        //WebDriverManager.chromedriver().setup();
        //this.driver = new ChromeDriver(chromeOptions);
        //webDriver.set(new ChromeDriver(chromeOptions));
        //driver.manage().window().maximize();
        //WebDriverManager.chromedriver().version("91.0.4472.101").setup();
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().deleteAllCookies();

        //To Run on Saucelabs
        ChromeOptions options = new ChromeOptions();
        options.setCapability("version", "latest");
        options.setCapability("platform","Windows 10");
        options.setCapability("name",jobName);
        //options.setCapability("name","test1");
        options.setCapability("build","kiran");
        //DesiredCapabilities caps = new DesiredCapabilities.chrome();

        //driver = new RemoteWebDriver(new URL(URL), options);
        webDriver.set(new RemoteWebDriver(new URL(URL), options));
        id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
        sessionId.set(id);
        return webDriver.get();

        //Geting System Environment from pom file
       /* if(System.getProperty("myname").equals("Kiran"))
            System.out.println("Environment :" +System.getProperty("myname") );*/
        //String id = driver.session_id;
       //return driver;
    }

    //@DataProvider(name= "DFDF")

    public WebDriver getWebDriver()
    {
        return webDriver.get();
    }
    @After
    public void tierDown()
    {

        webDriver.get().quit();
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