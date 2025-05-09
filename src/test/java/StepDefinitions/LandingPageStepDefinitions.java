package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.TestContext;
import MyCucumberRepository.*; // Ensure this is the correct package for the LandingPage class

public class LandingPageStepDefinitions {
	TestContext context;
	String url="https://rahulshettyacademy.com/seleniumPractise/#/";
	public LandingPageStepDefinitions(TestContext context){
		this.context=context;
	}
	@Given(": user is on landing page")
	public void user_is_on_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		context.driver = new ChromeDriver();
		LandingPage lauchbrow =new LandingPage(context.driver);
		lauchbrow.launchBrowserAndGetUrl(url);
	    
	}
	@When("^: user searched with (.+) and extarcted actual name of product$")
	public void user_searched_with_and_extarcted_actual_name_of_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		context.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);

		context.landingPageProductName=context.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("Searched product on landing page:--"+context.landingPageProductName);
	}
	
	
}
