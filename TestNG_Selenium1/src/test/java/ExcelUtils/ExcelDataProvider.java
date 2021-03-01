package ExcelUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
//	public static void main(String[] args) throws IOException {
//		
//	
//		String projectLocation = System.getProperty("user.dir");
//		testData(projectLocation+"/excel/data.xlsx", "Sheet1");
//		
//	}
	WebDriver driver = null;

	@BeforeTest
	public void setUpTest()
	{
		// TODO Auto-generated method stub
		Reporter.log("======browser session started===========", true);
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("======Application started===========", true);
		
	}
	@Test(dataProvider="test1data")
	public void test1(String username, String password) throws InterruptedException
	{
		System.out.println(username+" | "+password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Reporter.log("======entering credentials===========", true);

		Thread.sleep(2000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		Reporter.log("======browser session ended===========", true);

	}
	@DataProvider(name = "test1data")
	public Object[][] getData() throws IOException
	{
		String projectLocation = System.getProperty("user.dir");
        Object data[][] = testData(projectLocation+"/excel/data.xlsx", "Sheet1");
        return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) throws IOException
	{
		excelDemo excel = new excelDemo(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
			
		Object data[][] = new Object [rowCount-1][colCount];
				
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<colCount;j++)
			{
				String cellData = excelDemo.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}
