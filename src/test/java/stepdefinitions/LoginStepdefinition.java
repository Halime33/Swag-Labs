package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepdefinition {

LoginPage loginPage = new LoginPage();


    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {

        Driver.getDriver().get(ConfigReader.getProperty("test_url"));


    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field() {

        loginPage.loginPageUsername.sendKeys(ConfigReader.getProperty("valid_username"));
        loginPage.loginPagePassword.sendKeys(ConfigReader.getProperty("valid_password"));


    }

    @And("I click the Login Button")
    public void i_click_the_login_button() {

        loginPage.loginButton.click();


    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() {

       String actualUrl = Driver.getDriver().getCurrentUrl();
       String expectedUrl = "https://www.saucedemo.com/inventory.html";
       Assert.assertEquals(expectedUrl,actualUrl);

    }

    @And("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {

        loginPage.appLogo.isDisplayed();

    }

    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field() {

        loginPage.loginPageUsername.sendKeys(ConfigReader.getProperty("invalid_username"));
        loginPage.loginPagePassword.sendKeys(ConfigReader.getProperty("invalid_password"));

    }


    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String string) {

        String actualErrorMessage = loginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        String expectedErrorMessage= ConfigReader.getProperty("loginErrorMessage");
        Assert.assertTrue(loginPage.errorMessage.getText().contains(expectedErrorMessage));
//2.way:  Assert.assertTrue(loginPage.errorMessage.getText().contains("Sorry, this user has been banned."));



    }



}
