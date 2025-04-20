package MyCucumberRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.TestContext;

public class LandingPage {
    WebDriver driver;
    TestContext context;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    /*public LandingPage(TestContext context) {
        this.context = context;
    }*/
    public void launchBrowserAndGetUrl(String url) {
       // driver=new ChromeDriver();
        driver.manage().window().maximize();  
        driver.get(url);
    }

    
}
