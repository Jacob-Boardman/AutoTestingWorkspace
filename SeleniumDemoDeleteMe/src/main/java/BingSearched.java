import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearched {
	@FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	private WebElement searchResult;
	
	public String getSerach() {
		return searchResult.getText();
	}

}
