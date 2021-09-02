package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonSteps {

    private WebDriver driver;
    public static final String USERNAME = "oauth-kiranpzala-7937b";
    public static final String ACCESS_KEY = "2a485bfc-2ae9-41e9-9501-fe583a979946";
    public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    @Before
    WebDriver getDriver() throws MalformedURLException {
       /* MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        //sauceOptions.setCapability("name", testInfo.getDisplayName());
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");*/

        ChromeOptions options = new ChromeOptions();
        options.setCapability("version", "latest");
        options.setCapability("platform","Windows 10");
        options.setCapability("name","Test1");
        //DesiredCapabilities caps = new DesiredCapabilities.chrome();

        driver = new RemoteWebDriver(new URL(URL), options);

        return driver;
    }

    /*public WebDriver getDriver()
    {
        return driver;
    }*/

    @After
    public void tierDown()
    {
        //WebDriver driver = getDriver();
        driver.quit();
    }

}

