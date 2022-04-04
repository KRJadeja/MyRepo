package Actions;

import Elements.Common_Elements;
import StepDefinitions.CommonSteps;
import org.openqa.selenium.WebDriver;
import Util.ConfigFileReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Common_Actions {

    private WebDriver driver;

    Common_Elements common_elements;
    ConfigFileReader configFileReader = new ConfigFileReader();

    String url = configFileReader.getApplicationUrl();

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

    public void gotoViewerPage() throws InterruptedException {

        // Get the devtools from the running driver and create a session
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = configFileReader.getViewerUserName() + ":" + configFileReader.getViewerPassword();

        // Encoding the username and password using Base64 (java.util)
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

        // Pass the network header -> Authorization : Basic <encoded String>
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get(url);

    }

    public void gotoSubmitterurl() {

       // Get the devtools from the running driver and create a session
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = configFileReader.getSubmitterUserName() + ":" + configFileReader.getSubmitterPassword();

        // Encoding the username and password using Base64 (java.util)
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

        // Pass the network header -> Authorization : Basic <encoded String>
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get(url);
    }

    public void gotoApproverurl() {

        // Get the devtools from the running driver and create a session
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = configFileReader.getApproverUserName() + ":" + configFileReader.getApproverPassword();

        // Encoding the username and password using Base64 (java.util)
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

        // Pass the network header -> Authorization : Basic <encoded String>
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get(url);
    }
}