package Actions;

import Elements.Common_Elements;
import StepDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;
import Util.ConfigFileReader;
import java.net.MalformedURLException;


public class Common_Actions {

    private WebDriver driver;

    Common_Elements common_elements;
    ConfigFileReader configFileReader = new ConfigFileReader();

    String env = System.getProperty("environment");

    public Common_Actions(CommonSteps commonsteps) throws MalformedURLException {
        this.driver = commonsteps.getDriver();
        common_elements = new Common_Elements(driver);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void navigaetUrl(String nurl) {
        driver.navigate().to(nurl);
    }

    public void gotoBaseUrl() throws InterruptedException {

        String ssourl = configFileReader.getApplicationUrl();
        //System.out.println(ssourl+"======"+configFileReader.getViewerPassword());
        driver.get(ssourl);
        Thread.sleep(1000);

        System.out.println("Environment==="+ env);
        if(env.equals("e1")) {
            driver.navigate().to("https://www.facebook.com/");
            common_elements.loginId.sendKeys(configFileReader.getViewerUserName());
            common_elements.loginpwd.sendKeys(configFileReader.getViewerPassword());
            common_elements.loginbtn.click();
        }

    }
}