package StepDefinitions;

import org.testng.Assert;

import MyCucumberRepository.OffersPage;
import io.cucumber.java.en.Then;
import utils.TestContext;

public class OffersPageStepDefinition {
	
	String offerPageProductName;	
	TestContext context;
	//single responsibility principle
	//loosly coupled
	public OffersPageStepDefinition(TestContext context){
		this.context=context;
	}
	
	@Then("^: user searched for (.+) shortname in landingpage page$")
public void user_searched_for_shortname_in_offers_page(String string) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	OffersPage op=new OffersPage(context.driver);
	op.clickOnTopDeals();
	offerPageProductName=op.getProductName(string);
}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page()
	{
		Assert.assertEquals(offerPageProductName,context.landingPageProductName);
		context.driver.quit();
	}
}
