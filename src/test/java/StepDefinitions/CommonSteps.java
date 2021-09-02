package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps{

    private WebDriver driver;

    @Before
    WebDriver getDriver()
    {
           /* ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOptions);*/

        //WebDriverManager.chromedriver().version("91.0.4472.101").setup();
       /* WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        //driver.manage().deleteAllCookies();

        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       // driver.manage().window().maximize();

          System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
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

