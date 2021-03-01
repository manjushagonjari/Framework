package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Library.Utility;

public class InvalidLogin extends BaseClass {
	
	@Test
	public void googleSearch() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		//Utility.captureScreenShot(driver, "browser started");

		driver.findElement(By.id("email")).sendKeys("manjushagonjari5@gmail.com");
		//driver.findElement(By.id("pass")).sendKeys("Ranjana@1234");
		//driver.findElement(By.name("login")).click();
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File("./Screenshots/facebook.png"));
		//Utility.captureScreenShot(driver, "type Uname");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		//Assert.assertTrue(driver.getTitle().contains("title name"), "User is not able to login - Invalid Credentials");
		//System.out.println("Page title verified - user is able to login successfully");
		driver.quit();
		
	}

}
