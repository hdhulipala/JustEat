package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import PageObjects.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class searchrest extends TestBase{

	
	@Before
	public void setUp() throws IOException, InterruptedException {
		String prop = System.getProperty("user.dir") + "\\src\\test\\resources\\properties";
		String executable = System.getProperty("user.dir") + "\\src\\test\\resources\\executables";

		fis = new FileInputStream(prop + "\\OR.properties");
		OR.load(fis);
		if (driver == null) {
			if (OR.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", executable + "\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new ChromeDriver(options);
			}
		}		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(OR.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(OR.getProperty("testurl"));
		Thread.sleep(1000);
		Reporter.log("Navigated to :" + OR.getProperty("testurl"));
	}
	
	@Given("^I want food in Postcode \"(.*)\"")
	public void i_want_food_in_Postcode_AR_AA(String postcode) throws Throwable {
		
	    // Write code here that turns the phrase above into concrete actions
		
		type("search_xpath",postcode);
		
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		waitAndClickElement("button_xpath");
		Thread.sleep(5000);
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		getList("resultList_xpath");
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}


}
