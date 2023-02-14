package cucumberseleniumdemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import org.junit.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class SiteTestStepDefinitions {

    Context context = null;
    Alert alert = null;

    public SiteTestStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("the user's username is {string}")
    public void the_user_s_username_is(String username) {
    }

    @Given("the user's password is {string}")
    public void the_user_s_password_is(String password) {
    }

    @Given("the user enters {string} as their password")
    public void the_user_enters_as_their_password(String enteredPassword) {
    }

    @Given("{string} does not equal {string}")
    public void does_not_equal(String firstString, String secondString) {
        Assert.assertNotEquals(firstString, secondString);
    }

    @When("the user browses to the web page at {string}")
    public void the_user_browses_to_the_web_page(String webSiteAddress) {
        this.context.webDriver.get(webSiteAddress);
    }

    @When("the web page asks the user to sign in")
    public void the_web_page_should_ask_the_user_to_sign_in() {
        this.alert = this.context.webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @When("the user cancels out of the login box")
    public void the_user_cancels_out_of_the_login_box() {
        this.alert.dismiss();
    }

    @Then("the web page should allow access")
    public void the_web_page_should_allow_access() {
    }

    @Then("the user sees {string}")
    public void the_user_sees(String string) {
        WebElement webElement = this.context.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='" + string + "']")));
        Assert.assertEquals(string, webElement.getText());
    }
}
