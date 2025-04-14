package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

public class OffersPageStepDefinition {
	
	String offerPageProductName;	
	TestContext context;
	public OffersPageStepDefinition(TestContext context){
		this.context=context;
	}
	
	@Then("^: user searched for (.+) shortname in landingpage page$")
public void user_searched_for_shortname_in_offers_page(String string) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	context.driver.findElement(By.linkText("Top Deals")).click();
	Set<String> s1=context.driver.getWindowHandles();
	Iterator<String> i1=s1.iterator();
	String parentwindowhandle=i1.next();
	String childwindow=i1.next();
	context.driver.switchTo().window(childwindow);
	context.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	Thread.sleep(2000);
	offerPageProductName=context.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page()
	{
		Assert.assertEquals(offerPageProductName,context.landingPageProductName);
	}
}
