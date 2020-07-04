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


import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class SiteTestStepDefinitions {

    Context context = null;

    String username = null;
    String password = null;
    String enteredPassword = null;

    Alert alert = null;

    public SiteTestStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("the user's username is {string}")
    public void the_user_s_username_is(String username) {
        this.username = username;
    }

    @Given("the user's password is {string}")
    public void the_user_s_password_is(String password) {
        this.password = password;
    }

    @When("the user browses to the web page at {string}")
    public void the_user_browses_to_the_web_page(String webSiteAddress) {
        this.context.webDriver.get(webSiteAddress);
    }

    @When("the user is asked to log on")
    public void the_user_is_asked_to_log_on() {
        this.alert = this.context.webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @When("the user enters their username")
    public void the_user_enters_their_username() {
        this.alert.sendKeys(this.username + Keys.TAB);
    }

    @When("the user enters their password")
    public void the_user_enters_their_password() {
        this.alert.sendKeys(this.password);
    }

    @When("the user clicks the accept button")
    public void the_user_clicks_the_accept_button() {
        this.alert.accept();
    }
}
