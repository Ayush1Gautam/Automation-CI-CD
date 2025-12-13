package ayushgautamLLC.StepDefinitions;

import org.testng.Assert;

import ayushgautamLLC.Base.BaseTest;
import ayushgautamLLC.PageObjects.navbarRedirections;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavbarRedirectionsSteps extends BaseTest {

    navbarRedirections nav;

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        nav = new navbarRedirections(driver);
        // Assuming BaseTest already launches the app
    }

    @When("the user clicks on the Mobile link")
    public void the_user_clicks_on_the_mobile_link() {
        nav.clickMobile();
    }

    @Then("the Mobile page should be displayed")
    public void the_mobile_page_should_be_displayed() {
        Assert.assertTrue(nav.getTitle().contains("Mobile"));
        driver.navigate().back();
    }

    @When("the user clicks on the Home link")
    public void the_user_clicks_on_the_home_link() {
        nav.clickHome();
    }

    @Then("the Home page should be displayed")
    public void the_home_page_should_be_displayed() {
        Assert.assertTrue(nav.getTitle().contains("JioHome"));
        driver.navigate().back();
    }

    @When("the user clicks on the Business link")
    public void the_user_clicks_on_the_business_link() {
        nav.clickBusiness();
    }

    @Then("the Business page should be displayed")
    public void the_business_page_should_be_displayed() {
        Assert.assertTrue(nav.getTitle().contains("Business"));
        driver.navigate().back();
    }

    @When("the user clicks on the Support link")
    public void the_user_clicks_on_the_support_link() {
        nav.clickSupport();
    }

    @Then("the Support page should be displayed")
    public void the_support_page_should_be_displayed() {
        Assert.assertTrue(nav.getTitle().contains("Support"));
        driver.navigate().back();
    }
}
