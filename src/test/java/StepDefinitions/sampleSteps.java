package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class sampleSteps {
    WebDriver driver;
    public sampleSteps(CommonSteps commonsteps)
    {
        this.driver = commonsteps.getDriver();
    }
   /* @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {

        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }*/

    @Given("I open Facebook login page")
    public void i_open_facebook_login_page() {
        driver.get("https://www.facebook.com/");

        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("I verify that the logo is present on page")
    public void i_verify_that_the_logo_is_present_on_page() {

        boolean status = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div[1]/img")).isDisplayed();
        String t =driver.getTitle();
        System.out.println(t);
        //Assert.assertEquals(true,status);
        Assert.assertTrue(status);
        Assert.assertEquals("Facebook - Log In or Sign Up",t);
        // Write code here that tu"rns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

    }

    @Then("close browser")
    public void close_browser() {

        driver.quit();
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("I enter email as {string}")
    public void invalid_email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.name("login")).click();
    }

    @Then("It should redirect to login page with error message")
    public void itShouldRedirectToErrorPage() {

        System.out.println("Login failed");
        driver.quit();
    }

    //Ebay Search Steps
    @Given("I am on Ebay Home")
    public void i_am_on_ebay_home() {
        driver.get("https://www.ebay.com/");
    }

    @When("I search for {string} in {string} Category")
    public void i_search_for_in_category(String str1, String str2) throws Exception {
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(str1);
        List<WebElement> Category = driver.findElements(By.xpath("//select[@id=\"gh-cat\"]/option"));

        for(WebElement w : Category)
        {

            if(w.getText().equals(str2))
            {
                w.click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        Thread.sleep(3000);

    }

    @Then("It should display all items in that Category")
    public void it_should_display_all_items_in_that_category() {
        driver.quit();
    }

}