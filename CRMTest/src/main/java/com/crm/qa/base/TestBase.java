package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	//static variable gets memory only once in the class area
	//can be used to refer to the common properties of all objects
	
	
	public static WebDriver driver;// defined global variables and can be used inside through out the child class and
								// test base class
	public static Properties prop;

	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws FileNotFoundException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Java_Pratiksha\\CRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initialization() throws FileNotFoundException {
		
String browserName = prop.getProperty("browser");
		
	/*if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Browser\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		*/
		
		
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		

		

	}

}
