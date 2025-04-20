package MyCucumberRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    WebDriver driver;
    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnTopDeals() {
        driver.findElement(By.linkText("Top Deals")).click();
        
    }
    public String getProductName(String string) throws InterruptedException {
        Set<String> s1=driver.getWindowHandles();
	Iterator<String> i1=s1.iterator();
	String parentwindowhandle=i1.next();
	String childwindow=i1.next();
	driver.switchTo().window(childwindow);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	Thread.sleep(2000);
	
    return driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }
    
}
