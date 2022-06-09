package com.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.pages.EbayHomePage;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileInputStream fis;
	private static final Logger log = LogManager.getLogger(TestBase.class);
	
	
	public void TestBase() {
		
		 

		try {
			fis = new FileInputStream(
					(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// =====
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		// ======
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}

	public void closeBrowser() {
		
		log.info("Browser closed");
		driver.close();
		
	}
	
	
	
	public void quitBrowser() {
		
		log.info("quitting all the browsers");
		driver.quit();
	}

}
