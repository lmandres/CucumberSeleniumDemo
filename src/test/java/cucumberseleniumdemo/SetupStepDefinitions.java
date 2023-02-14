package cucumberseleniumdemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SetupStepDefinitions {

    Context context = null;
    int waitInSeconds = 20;

    public SetupStepDefinitions(Context context) {
        this.context = context;
    }

    @Before
    public void create_and_set_up_selenium_webdriver() {

        System.setProperty("webdriver.chrome.driver", "/mnt/c/Users/Leo Andres/develop/testdir/chromedriver");

        ChromeOptions opts = new ChromeOptions();

        opts.addArguments("--headless");
        opts.addArguments("--incognito");
        opts.addArguments("--no-sandbox");

        this.context.webDriver = new ChromeDriver(opts);
        //this.context.webDriver = new FirefoxDriver();
        this.context.webDriverWait = new WebDriverWait(this.context.webDriver, Duration.ofSeconds(this.waitInSeconds));
    }

    @After
    public void quit_and_destroy_selenium_webdriver() {
        this.context.webDriver.quit();
        this.context.webDriver = null;
    }
}
