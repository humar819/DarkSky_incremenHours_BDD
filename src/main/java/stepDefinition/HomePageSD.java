package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.HomePage;
import utilis.BasePage;

public class HomePageSD {
HomePage homePage = new HomePage();

    @Given("I am on the Dark Sky home page")
    public void i_am_on_the_dark_sky_home_page() {
        String homeTitle = BasePage.get().getTitle();
        System.out.println("Home page title is : " + homeTitle);
        Assert.assertEquals(homeTitle,"Dark Sky - 1 City Hall, New York, NY");
    }

    @When("I enter city into search text field on home screen")
    public void i_enter_city_into_search_text_field_on_home_screen() throws InterruptedException {
      homePage.enterCityName("Tampa");
      Thread.sleep(2000);
      homePage.clickSearchBtn();

    }

    @And("I verify city’s time zone")
    public void i_verify_city_s_time_zone() throws InterruptedException {
     homePage.verifyTimeZone("Milan");
    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() {
   homePage.getTimeIncrement();
    }

}
