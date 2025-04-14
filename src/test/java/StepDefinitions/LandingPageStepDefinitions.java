package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	TestContext testContext;
	public LandingPageStepDefinitions(TestContext context) {
		testContext = context;
		driver = testContext.driver;
	}
	@Given(": user is on landing page")
	public void user_is_on_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	}
	@When("^: user searched with (.+) and extarcted actual name of product$")
	public void user_searched_with_and_extarcted_actual_name_of_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(":user searched with "+string+" and extarcted actual name of product");
	    
	}
	@Then("^: user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(":user searched for "+string+ " shortname in offers page");
	}
	@Then(": validate products name in offers page matches with landing page")
	public void validate_products_name_in_offers_page_matches_with_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(": validate products name in offers page matches with landing page");
		driver.quit();
	}

}
