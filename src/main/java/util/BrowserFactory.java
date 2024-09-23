package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

static WebDriver driver;
static String browser;
static String url;

public static void readConfig()
{
	Properties prop = new Properties();
	try {
		FileInputStream fs = new FileInputStream("src\\main\\java\\config\\config.properties");
		prop.load(fs);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
	
	public static WebDriver init()
	{
		readConfig();
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "src\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "src\\drivers1\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else
		{
			System.out.println("Enter valid driver");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();	
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
