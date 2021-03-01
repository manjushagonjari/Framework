package Library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	
	public static String captureScreenShot(WebDriver driver)
	{
	String screenshotPath = System.getProperty("user.dir")+"/Screenshots/login_"+ getCurrentDateTime() +".png";	
	
	try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(screenshotPath));
		System.out.println("Screenshot Captured");
	} catch (Exception e) {
		System.out.println("Exception while taking screenshot :"+e.getMessage());
	}
	return screenshotPath; 
	}

	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}
}
