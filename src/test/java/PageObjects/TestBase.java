
package PageObjects;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class TestBase{


	public static WebDriver driver; // created reference
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static String browser;
	public static Actions action;
	


	public void waitAndClickElement(String locator) {
		boolean clicked= false;
		int attempt= 0;
		action = new Actions(driver);
		while(!clicked && attempt<10) {
			try {
				if (locator.endsWith("_CSS")) {
						action.moveToElement(driver.findElement(By.cssSelector(OR.getProperty(locator)))).click().build().perform();
					} else if (locator.endsWith("_xpath")) {
						action.moveToElement(driver.findElement(By.xpath(OR.getProperty(locator)))).click().build().perform();

					} else if (locator.endsWith("_id")) {
						action.moveToElement(driver.findElement(By.id(OR.getProperty(locator)))).click().build().perform();
					}
			    System.out.println("Successfully clicked on the WebElement: " + "<" + locator + ">");
				clicked = true;
			}catch(Exception e) {
				System.out.println("Unable to wait and click on WebElement, Exception: "+ e.getMessage());
				Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + locator + ">");
				
			}
			attempt++;
		}
	}
	
	
	public void type(String locator, String value) throws InterruptedException {
		
		action = new Actions(driver);
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("name")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}

		Thread.sleep(1000);
	}
	
	public void selectFromList(String locator, String value) throws InterruptedException {
		List<WebElement> elements= driver.findElements(By.xpath(OR.getProperty(locator)));
		for(WebElement element: elements) {
			if(element.getText().contains(value)) {
				element.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void getList(String locator) {
		  List<WebElement> results= driver.findElements(By.xpath(OR.getProperty("resultList_xpath")));
		  int count = results.size();
		  System.out.println("Total results " + count);
			for (WebElement el : results) {
				System.out.println(el.getText());

			}
	}
	


}


