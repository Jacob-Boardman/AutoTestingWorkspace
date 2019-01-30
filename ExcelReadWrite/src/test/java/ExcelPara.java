import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ExcelPara {
	
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

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		FileInputStream file = new FileInputStream(Constants.excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][4];

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for (int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells()-1; colNum++) {
				ob[rowNum-1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}
			ob[rowNum-1][3] = rowNum;
		}

		file.close();
		return Arrays.asList(ob);
	}

	private String username;
	private String password;
	private String expected;
	private int row;

	public ExcelPara(String username, String password, String expected, int row) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.row = row;
	}
	
	@Test
	public void login() throws IOException {
		
		System.out.println(username +" "+ password + " " + expected + " " + row);
		
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		
		ExcelDemoLandingPage edlp = PageFactory.initElements(driver, ExcelDemoLandingPage.class);
		
		edlp.createAndLogin(username, password);
		WebElement login = driver.findElement(By.xpath(Constants.login));
		login.click();
		edlp.createAndLogin(username, password);
		
		FileInputStream file = new FileInputStream(Constants.excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFRow rowy = sheet.getRow(row);
		XSSFCell cellActual = rowy.getCell(3);
		XSSFCell cellResult = rowy.getCell(4);
		if (cellActual == null) {
			cellActual = rowy.createCell(3);
		}
		WebElement text = driver.findElement(By.xpath(Constants.text));
		cellActual.setCellValue(text.getText());
		
		if(cellResult == null) {
			cellResult = rowy.createCell(4);
		}
			
		if(expected.equals(text.getText())) {
			cellResult.setCellValue("Pass");								
		}
		else {
			cellResult.setCellValue("Fail");
		}
		
		
		WebElement adduser = driver.findElement(By.xpath(Constants.adduser));
		adduser.click();

	
	
	FileOutputStream fileOut = new FileOutputStream(Constants.excelpath);
	
	workbook.write(fileOut);
	fileOut.flush();
	file.close();
		
		
	}


}
