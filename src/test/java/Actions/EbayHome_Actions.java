package Actions;

import Elements.EbayHome_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import StepDefinitions.CommonSteps;

import java.net.MalformedURLException;
import java.util.List;

public class EbayHome_Actions {
	
	private WebDriver driver;
	EbayHome_Elements ebayhome_elements;
	
	public EbayHome_Actions(CommonSteps common_steps) throws MalformedURLException {
		this.driver = common_steps.getDriver();
		ebayhome_elements = new EbayHome_Elements(driver);
	}
	
	public void clickAdvancedLink() {
		ebayhome_elements.advancedLink.click();
	}
	
	public void searchAnItem(String srchString) {
		ebayhome_elements.searchBox.sendKeys(srchString);
	}
	
	public void clickSearchButton() {
		ebayhome_elements.searchButton.click();
	}
	
	public int getSeatchItemsCount() {
		String itemCount = ebayhome_elements.numOfItems.getText().trim();	
		String itemCount2 = itemCount.replace(",", "");
	    int itemCountInt = Integer.parseInt(itemCount2);
	    return itemCountInt;
	}
	
	public void selectCategoryOption(String option) {
		List<WebElement> cat = ebayhome_elements.catOptions;
		for(WebElement x : cat) {
			if(x.getText().trim().toLowerCase().equals(option.toLowerCase())) {
				x.click();
				break;
			}
		}
	}
	
	public void clickOnLinkByText(String Text) {
		driver.findElement(By.linkText(Text)).click();
	}

	public void enterUidPwd(String uid, String pwd) {
		ebayhome_elements.loginId.sendKeys(uid);
		ebayhome_elements.loginpwd.sendKeys(pwd);
		ebayhome_elements.loginbtn.click();
	}
}
