package StepDefinitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    private WebDriver driver;

    @Before
    public void setUp()
    {
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\KJadeja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

   /* @After
    public void tierDown()
    {
        driver.quit();
    }*/

    public WebDriver getDriver()
    {
        return driver;
    }
}
