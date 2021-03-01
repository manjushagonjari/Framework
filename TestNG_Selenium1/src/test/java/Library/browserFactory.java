package Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class browserFactory {
	//In progress**************
		public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
		{
			if(browserName.equals("Chrome"))
			{
				String projectLocation = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", projectLocation+"/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("Firefox"))
			{
				String projectLocation = System.getProperty("user.dir");
				System.setProperty("webdriver.gecko.driver", projectLocation+"/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE"))
			{
				String projectLocation = System.getProperty("user.dir");
				System.setProperty("webdriver.ie.driver", projectLocation+"/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else
			{
				System.out.println("We do not support this browser");
			}
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(appURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
		}
	//In progress********************
		
		public static void afterTest(WebDriver driver)
		{
			driver.quit();
			System.out.println("Test completed successfully");
			Reporter.log("======browser session ended===========", true);

		}

}
