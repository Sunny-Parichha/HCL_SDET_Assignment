package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;


public class LoginStepDefination {

    String driverPath = "C://Users//Abhishek//Downloads//SDET_Assignment//xxx//chromedriver.exe";
    public WebDriver driver;

    @Given("^user is already on Return Order Request Page$")
    public void user_is_already_on_Return_Order_Request_Page() throws Throwable {
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://return-order-app.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @When("^the user enters the (\\d+) in the order Id field and then enters Find order$")
    public void the_user_enters_the_in_the_order_Id_field_and_then_enters_Find_order(String orderId) throws Throwable {

        WebElement Header = driver.findElement(By.xpath("//h1"));
        WebElement OrderIdLabel = driver.findElement(By.xpath("//label[contains(text(), 'Order Id')]"));
        WebElement OrderIdField = driver.findElement(By.xpath("//input[@id='order-id']"));
        WebElement FindOrderButton = driver.findElement(By.xpath("//button[contains(text(), 'Find Order')]"));

        Assert.assertTrue(Header.isDisplayed());
        Assert.assertTrue(OrderIdLabel.isDisplayed());
        Assert.assertTrue(OrderIdField.isDisplayed());
        Assert.assertTrue(FindOrderButton.isDisplayed());

        OrderIdField.sendKeys(orderId);
        FindOrderButton.click();
    }

    @Then("^the product purchased details are displayed and validated$")
    public void the_product_purchased_details_are_displayed_and_validated() throws Throwable {
        WebElement productSection = driver.findElement(By.xpath("//div[@class='product-section']"));

        Assert.assertTrue(productSection.isDisplayed());
    }

    @Then("^the user clicks on Return This Product button$")
    public void the_user_clicks_on_Return_This_Product_button() throws Throwable {
        WebElement returnProductButton = driver.findElement(By.xpath("//button[contains(text(), 'Return')]"));

        Assert.assertTrue(returnProductButton.isDisplayed());

        returnProductButton.click();
    }

    @Then("^then a token will be generated with a Return Order Placed$")
    public void then_a_token_will_be_generated_with_a_Return_Order_Placed() throws Throwable {
        WebElement secretToken = driver.findElement(By.xpath("//div[@class='result']"));
        WebElement confirmationMessage = driver.findElement(By.xpath("(//h1)[2]"));

        Assert.assertTrue(secretToken.isDisplayed());
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @Then("^the token is stored in text file$")
    public void the_token_is_stored_in_text_file() throws Throwable {
        WebElement secretToken = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue(secretToken.isDisplayed());

        String output = secretToken.getText();
        File file= new File("result.txt");
        FileWriter fw = new FileWriter(file);
        fw.write(output);
        fw.close();
    }

    @Then("^Close the browser$")
    public void close_the_browser() throws Throwable {
        driver.close();
        driver.quit();
    }
}
