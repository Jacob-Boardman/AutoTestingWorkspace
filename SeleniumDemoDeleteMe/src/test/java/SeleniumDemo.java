import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

//	@Test
//	@Ignore
//	public void testy() throws InterruptedException {
////		driver.manage().window().maximize();
////		driver.get("http://www.bing.com");
////		WebElement textbox = driver.findElement(By.name("q"));
////		textbox.sendKeys("Selenium");
////		textbox.submit();
////		WebElement sele = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
////		Thread.sleep(3000);
////		assertEquals("Selenium Text not found","Selenium", sele.getText());
//		
//		driver.manage().window().maximize();
//		driver.get("http://localhost:3000/users");
//		WebElement firstName = driver.findElement(By.className("firstName"));
//		firstName.sendKeys("Bob");
//		WebElement secondName = driver.findElement(By.className("secondName"));
//		secondName.sendKeys("Doorman");
//		WebElement age = driver.findElement(By.className("age"));
//		age.sendKeys("45");
//		WebElement genre = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/form/select/option[4]"));
//		genre.click();
//		WebElement submit = driver.findElement(By.className("userSubmit"));
//		submit.click();
//		
//		
//		Thread.sleep(3000);
//		
//	}
	
//	@Test
//	@Ignore
//	public void testy2() throws InterruptedException {
//		driver.manage().window().maximize();
//		driver.get(Constants.URL);
//		BingLandingPage blp = PageFactory.initElements(driver, BingLandingPage.class);
//		blp.searchBing("selenium");
//		BingSearched bs = PageFactory.initElements(driver, BingSearched.class);
//		assertEquals("Selenium not found","Selenium", bs.getSerach());
//		Thread.sleep(2000);
//		
//	}
	
//	@Test
//	public void testy3() throws InterruptedException {
//		driver.manage().window().maximize();
//		driver.get(Constants.URL2);
//		Actions action = new Actions(driver);
//		WebElement painter = driver.findElement(By.id("painter"));
//		action.moveToElement(painter).moveByOffset(-200,-200).clickAndHold()
//		.moveByOffset(100, 0)
//		.moveByOffset(-50, 0)
//		.moveByOffset(0, 150)
//		.moveByOffset(-50, 0)
//		.perform();
//		Thread.sleep(2000);
//	}
	
//	@Test
//	public void testy4()  throws InterruptedException {
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(Constants.URL3);
//		WebElement iHateYou = driver.findElement(By.xpath("//*[@id=\"quote\"]/h2"));
//		Thread.sleep(100);
//		assertEquals("Not found -The Shafeeq","-The Shafeeq",iHateYou.getText());
//		
//		
//	}
	
	@Test
	public void testy5() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL3);
		WebElement iHateYou = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"quote\"]/h2")));
		assertEquals("Not found -The Shafeeq","-The Shafeeq",iHateYou.getText());
		
	}
}
