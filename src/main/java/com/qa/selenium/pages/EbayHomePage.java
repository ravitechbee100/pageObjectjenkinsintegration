package com.qa.selenium.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/*import java.util.logging.LogManager;

import org.apache.logging.log4j.core.Logger;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.TestBase;

public class EbayHomePage extends TestBase {

	// By signin = By.xpath("//*[@id=\"gh-ug\"]/a");
	private By signin = By.xpath("//*[contains(text(),'Sign in')]");
	private By ebayLogo = By.id("gh-la");
	By register = By.xpath("//*[@id=\"gh-ug-flex\"]/a");
	By searchButton = By.id("gh-btn");
	By searchItem = By.id("gh-ac");
	By selectCategories = By.id("gh-cat");

	// @FindBy(id="gh-btn")
	 //WebElement searchButton;

	private static final Logger log = LogManager.getLogger(EbayHomePage.class);

	public WebElement signinlink() {
		log.info("click on SignIn link");

		return driver.findElement(signin);
		
	}

	public void clickebayLogo() {

		driver.findElement(ebayLogo).click();
		log.info("click on ebayLogo");
	}

	public void registrationLink() {
		driver.findElement(register).click();
		log.info("click on registration Link");

	}
	
	/*Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)							
			.withTimeout(30, TimeUnit.SECONDS) 			
			.pollingEvery(5, TimeUnit.SECONDS) 			
			.ignoring(NoSuchElementException.class);
	WebElement searchbutton1 = fluentwait.until(new Function<WebDriver, WebElement>(){
	
		public WebElement apply(WebDriver driver ) {
			return driver.findElement(searchButton);
		}
	});*/

	public void searchButton() {

		log.info("Click on Search Button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchButton)));
		driver.findElement(searchButton).click();
		//searchButton.click();
			
				
	}

	
	public void searchItem(String searchitem) {

		driver.findElement(searchItem).sendKeys(searchitem);
		log.info("Enter the search Item");
	}
	
	

	public void selectSearchCategories(String categoryName) {

		List<WebElement> elements = driver.findElements(selectCategories);

		if (elements == null) {

			log.error("No Elements exist");
		}
		// log.error("Category Not selected properly");
		log.warn("PLease do select a drop down value");
		log.info("drop down selected");
		log.debug("drop value is troubleshoot");

		for (WebElement e : elements) {

			Select s = new Select(e);
			s.selectByVisibleText(categoryName);
		}

	}

	public String searchButtonText() {

		log.info("Get text from search button");
		return driver.findElement(searchButton).getText();
		// return searchButton.getText();

	}

}
