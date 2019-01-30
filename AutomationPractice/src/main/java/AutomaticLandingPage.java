import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomaticLandingPage {
	
	@FindBy(id = "search_query_top")
	private WebElement search;
	
	@FindBy(name = "submit_search")
	private WebElement button;
	
	public void searchDress(String dress) {
		search.sendKeys(dress);
		button.click();
	}

}
