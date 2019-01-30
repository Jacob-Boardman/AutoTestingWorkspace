import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {
	
	@FindBy(id = "sb_form_q")
	private WebElement sb;
	
	public void searchBing(String input) {
		sb.sendKeys(input);
		sb.submit();
	}
}
