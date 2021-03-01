package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ExcelUtils.excelDemo;
import Library.ConfigDataProvider;
import Library.Utility;
import Library.browserFactory;

public class BaseClass {

	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public ExtentTest test;
	public ConfigDataProvider config;

	String ExtentReportsPath = System.getProperty("user.dir")+"/Reports/login_"+ Utility.getCurrentDateTime() +".html";	
	@BeforeSuite
	public void setUpTest()
	{
		//String projectLocation = System.getProperty("user.dir");
		htmlReporter = new ExtentHtmlReporter(ExtentReportsPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		config = new ConfigDataProvider();

	}

	@BeforeClass
	public void beforeTest()
	{
		// TODO Auto-generated method stub
		Reporter.log("======browser session started===========", true);
		driver = browserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
		Reporter.log("======Application started===========", true);

	}

	@AfterClass
	public void afterTest()
	{
		//		driver.quit();
		//		System.out.println("Test completed successfully");
		//		Reporter.log("======browser session ended===========", true);
		browserFactory.afterTest(driver);

	}

	@AfterSuite
	public void tearDown()
	{
		// calling flush writes everything to the log file
		extent.flush();

	}
	

//
//	@AfterMethod
//	public void tearDownMethod(ITestResult result) throws IOException
//	{
//		try {
//			if(result.getStatus()==ITestResult.FAILURE)
//			{
//
//				test.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());		
//			}
//			else if(result.getStatus()==ITestResult.SUCCESS)
//			{
//
//				//test.pass("Login passed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());		
//				test.log(Status.PASS, "login passed");
//
//			}
//			
//			extent.flush();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("error caught"+e.getMessage());
//		}
//
//	}
	@DataProvider(name = "test1data")
	public Object[][] getData() throws IOException
	{
		String projectLocation = System.getProperty("user.dir");
		Object data[][] = testData(projectLocation+"/excel/data.xlsx", "Sheet1");
		return data;
	}
	//method used for excel file
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
