package StepDefinitions;

import Actions.Common_Actions;
import Actions.EbayHome_Actions;
import Util.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import Util.MyAppProperties;

import static org.junit.Assert.*;

public class EbayHome_Steps {
	Common_Actions common_actions;
	EbayHome_Actions ebayhome_actions;
	ConfigFileReader configFileReader = new ConfigFileReader();

	public EbayHome_Steps(Common_Actions common_actions, EbayHome_Actions ebayhome_actions) {
		this.common_actions = common_actions;
		this.ebayhome_actions = ebayhome_actions;
	}
	
	@Given("I am on Eaby Home Page")
	public void i_am_on_Eaby_Home_Page() {
		common_actions.goToUrl("https://www.ebay.com/");
		//common_actions.navigaetUrl(configFileReader.getApplicationUrl());

	}

	@When("I click on Advanced Link")
	public void i_click_on_Advanced_Link() {
	    ebayhome_actions.clickAdvancedLink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_Advanced_Search_page() {
	    String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	    String actUrl = common_actions.getCurrentPageUrl();
		Assert.assertEquals(expUrl,actUrl);
		CommonSteps.testResults =true;
	    /*if (!expUrl.equals(actUrl)) {
	    	fail("Page does not navigae to expected page");
	    }*/
	}
	
	@When("I serach for {string}")
	public void i_serach_for_iPhone_11(String str1) throws Exception {
		ebayhome_actions.searchAnItem(str1);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}

	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_presentint (int count) {
			int itemCountInt = ebayhome_actions.getSeatchItemsCount();
			//Assert.assertEquals(count, itemCountInt);

			if(itemCountInt < count) {
				fail("Less than 1000 results shown");
			}
			else
			{
				CommonSteps.testResults=true;
			}
	}
	
	@When("I serach for {string} in {string} category")
	public void i_serach_for_in_category(String string, String string2) throws Exception {
		ebayhome_actions.searchAnItem(string);
		ebayhome_actions.selectCategoryOption(string2);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) throws Exception {
	   ebayhome_actions.clickOnLinkByText(string);
	   Thread.sleep(1000);
	}

	@Then("I validate that page navigates to {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url) {
	    String actUrl = common_actions.getCurrentPageUrl();
	   // String actTitle = common_actions.getCurrentPageTitle();
	    Assert.assertEquals(url,actUrl);
	    CommonSteps.testResults=true;
		//Assert.assertEquals(title,actTitle);
	   /* if (!actUrl.equals(url)) {
	    	fail("Page does navigate to expected url: " + url);
	    }
	    if (!actTitle.contains(title)) {
	    	fail("Title mismatch");
	    }*/
	}

	@When("I enter valid credential in given textbox and click login button")
	public void iEnterValidCredentialInGivenTextboxAndClickLoginButton() {
		ebayhome_actions.enterUidPwd(configFileReader.getViewerUserName(),configFileReader.getViewerPassword());
	}

	@Given("User logged in as Viewer")
	public void iLaunchHerokuappWithBasicAuth() throws InterruptedException {
		//String str = "https://"+MyAppProperties.getUserId()+":"+MyAppProperties.getPwd()+"@the-internet.herokuapp.com/basic_auth";
		//System.out.println("URL  "+str);
		common_actions.gotoViewerPage();
	}

	@Then("I navigate to Welcome page")
	public void iNavigateToWelcomePage() {
		String actmsg = ebayhome_actions.showwelcomemsg();
		Assert.assertTrue(actmsg.contains("Congratulations"));
		CommonSteps.testResults=true;
	}

	// For Facebook Login
	@Given("I am on Facebook Login page")
	public void iAmOnFacebookLoginPage() {
		common_actions.goToUrl("https://www.facebook.com/");
	}

	@When("I enter {string} and {string} in given textbox and click login button")
	public void enter_useridnpwwd(String uid, String pwd) {
		ebayhome_actions.enterUidPwd(uid,pwd);
	}

	@Then("It should redirect me to page")
	public void itShouldRedirectMeToPage() {
		String acturl = common_actions.getCurrentPageUrl();
		System.out.println("Page Redircted to : "+ acturl);

	}

	@Given("I am on required page")
	public void iAmOnRequiredPage() {
		common_actions.goToUrl("https://qavbox.github.io/demo/delay/");
	}

	@When("I click on try me")
	public void iClickOnTryMe() {
		ebayhome_actions.clicktryme();
	}

	@Then("displays text {string}")
	public void displaysTextIAppearedAfterSec(String str) {
		String acttext=ebayhome_actions.gettext();
	}

	@Given("User logged in as submitter")
	public void userLoggedInAsSubmitter() {
		common_actions.gotoSubmitterurl();
	}

	@Given("User logged in as approver")
	public void userLoggedInAsApprover() {
		common_actions.gotoApproverurl();
	}
}