package Actions;

import Elements.Common_Elements;
import StepDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;
import util.MyAppProperties;

import java.net.MalformedURLException;
import java.rmi.server.UID;

public class Common_Actions {
    String uid="admin";//System.getenv("USID");
    String pwd="admin";//System.getenv("PWD");
    private WebDriver driver;

    Common_Elements common_elements;

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
        /*String str = "https://"+ MyAppProperties.getUserId()+":"+MyAppProperties.getPwd()+"@the-internet.herokuapp.com/basic_auth";
        driver.get(str);*/
        String str = "https://"+uid+":"+pwd+"@the-internet.herokuapp.com/basic_auth";
        driver.get(str);
        Thread.sleep(1000);
        driver.navigate().to("https://www.facebook.com/");
        common_elements.loginId.sendKeys("abc");
        common_elements.loginpwd.sendKeys("abc@123");
        common_elements.loginbtn.click();
        //System.out.println("uid  "+uid);
    }
}
