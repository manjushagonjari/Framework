package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGdemo {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest()
	{
		// TODO Auto-generated method stub
		
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	
	}
	@Test
	public void googleSearch()
	{
		driver.get("https://google.com");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
}
