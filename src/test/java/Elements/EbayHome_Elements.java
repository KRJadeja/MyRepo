package Elements;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class EbayHome_Elements {
	
	WebDriver driver;

	@FindBy(linkText = "Advanced") public WebElement advancedLink;
	@FindBy(xpath = "//input[@id='gh-ac']") public WebElement searchBox;
	@FindBy(xpath = "//input[@id='gh-btn']") public WebElement searchButton;
	@FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child") public WebElement numOfItems;
	@FindBy(xpath = "//select[@id='gh-cat']/option']") public List<WebElement> catOptions;

	@FindBy(xpath = "//*[@id=\"email\"]") public WebElement loginId;
	@FindBy(xpath = "//*[@id=\"pass\"]") public WebElement loginpwd;
	@FindBy(xpath = "//*[@name=\"login\"]") public WebElement loginbtn;
	@FindBy(xpath = "//*[@id=\"content\"]/div/p") public WebElement msg;

	@FindBy(name ="commit1") public WebElement tryme;
	@FindBy(id ="delay") public WebElement hiddenele;


	public EbayHome_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}