package Actions;

import StepDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Common_Actions {
    private final WebDriver driver;

    //CommonSteps commonsteps;

    public Common_Actions(CommonSteps commonsteps) throws MalformedURLException {
        this.driver = commonsteps.getDriver();
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
}
