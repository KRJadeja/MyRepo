package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Common_Elements {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"email\"]") public WebElement loginId;
    @FindBy(xpath = "//*[@id=\"pass\"]") public WebElement loginpwd;
    @FindBy(xpath = "//*[@name=\"login\"]") public WebElement loginbtn;


    public Common_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
