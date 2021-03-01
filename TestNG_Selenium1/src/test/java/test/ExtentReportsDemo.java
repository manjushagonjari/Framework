package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.Login_POM;

import ExcelUtils.excelDemo;
import Library.Utility;

public class ExtentReportsDemo extends BaseClass 
{

	@Test(dataProvider="test1data", description="Login with credentials")
	public void test1(String username, String password) throws InterruptedException, IOException
	{
		//code for extent reports

		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "login");
		test.info("Starting Application");
		//test.log(Status.FAIL, "login");
		//test.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
		
		
		
		
		System.out.println(username+" | "+password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		//created page_object using pageFactory
		Login_POM login_page= PageFactory.initElements(driver, Login_POM.class);
		//call the method
		login_page.login_hrm(username, password);
		//Utility.captureScreenShot(driver, "login Passed");
		test.log(Status.FAIL, "login");
		test.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
		//Fetching Title
//		System.out.println(driver.getTitle());
//		Assert.assertTrue(driver.getTitle().contains("title name"), "User is not able to login - Invalid Credentials");
//		System.out.println("Page title verified - user is able to login successfully");
	}
	


}
