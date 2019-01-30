import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AutomaticTesting {
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
	
	@Test
	public void test1() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		AutomaticLandingPage alp = PageFactory.initElements(driver, AutomaticLandingPage.class);
		alp.searchDress("dress");
		WebElement dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a"));
		assertEquals("Not dress found","Printed Dress",dress.getText());
	}
	

}
