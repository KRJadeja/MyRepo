package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    //private WebDriver driver;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static boolean testResults;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @After
    public void tierDown() {
        driver.get().quit();
    }

}
