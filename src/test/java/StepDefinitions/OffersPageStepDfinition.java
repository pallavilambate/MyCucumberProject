package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

public class OffersPageStepDfinition {
	public WebDriver driver;
    TestContext testContext;
    String actualName="";
    String expected="";
    public OffersPageStepDfinition(TestContext context) {
        testContext = context;
        driver = context.driver;
    }
    @Given("I am on the offers page")
public void i_am_on_the_offers_page() {
    // Write code here that turns the phrase above into concrete actions
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    driver.manage().window().maximize();
    System.out.println("I am on the offers page");
}
@When("search for {string} and extract the actual name of the product")
public void search_for_and_extract_the_actual_name_of_the_product(String string) {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(string);
    WebElement present=driver.findElement(By.xpath("//tr[1]/td[1]"));
    String actualName=present.getText();
    String expected="Tomato";
    
}
@Then("I should see {string} in the search results")
public void i_should_see_in_the_search_results(String string) {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(actualName,expected,string+" not found in the search results");
}
@Then("search on offers page and validate the product name matches with the landing page")
public void search_on_offers_page_and_validate_the_product_name_matches_with_the_landing_page() {
    // Write code here that turns the phrase above into concrete actions
    driver.quit();
}
}
