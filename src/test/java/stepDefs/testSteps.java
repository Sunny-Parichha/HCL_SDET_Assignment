package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testSteps {

    String driverPath = "C://Users//Abhishek//Downloads//SDET_Assignment//latestDriver//chromedriver.exe";
    public WebDriver driver;

    @Given("^user is  on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    }
}
