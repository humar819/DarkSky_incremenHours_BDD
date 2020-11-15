package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.RegisterPage;
import utilis.BasePage;

public class RegisterSD {

   RegisterPage registerPage= new RegisterPage();


    @Given("I am on the darksky home page")
    public void homePageTitle() throws InterruptedException {
    String homeTitle = BasePage.get().getTitle();
    System.out.println("Home page title is : " + homeTitle);
    Assert.assertEquals(homeTitle,"Dark Sky - 1 City Hall, New York, NY");
    }

    @When("I select Dark Sky API option and Login button")
    public void clickAPIAndLoginBtn() throws InterruptedException {
        registerPage.clickAPIAndLogin();
    }

    @Then("I am on Dark Sky Register page")
    public void verifyRegisterPageTitle(){
       String registerPageTitle = BasePage.get().getTitle();
        System.out.println("Register page title : " + registerPageTitle);
        Assert.assertEquals(registerPageTitle,"Dark Sky API: Log In");
    }



    @And("I enter abc@gmail.com into email text fields on login page")
    public void enterUsername(){
      registerPage.enterUserName("abc@gmail.com");
    }

    @And("I enter password1 into password text fields on login page")
    public void enterPassword(){
      registerPage.enterPassword("password1");
    }

    @And("I click submit button")
    public void i_click_submit_button(){
        registerPage.clickSubmitBtn();
    }


    @Then("I verify error message “password and username does not match”")
    public void i_verify_error_message_password_and_username_does_not_match() {
      String errorMessage= registerPage.errorMessage();
      System.out.println("Error message is : " + errorMessage);
        Assert.assertTrue(errorMessage.matches("Username and password do not match"));
    }





}
