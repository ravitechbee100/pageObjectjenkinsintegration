package SeleniumFrameworkMay2022.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.selenium.pages.EbayHomePage;

public class HomePageTest {

	EbayHomePage eb = new EbayHomePage();
	
	@BeforeTest
	public void launchWebsite() {
		eb.TestBase();
	}

	@Test
	public void testHomepage() {

		
		//eb.signinlink();
		eb.signinlink().click();
		eb.clickebayLogo();
		eb.registrationLink();
		//eb.closeBrowser();

	}

	@Test
	public void testDropDownValues() {
		// String searchText;

		// searchText = eb.searchButtonText();
		SoftAssert softAssert = new SoftAssert();
		//eb.TestBase();

		// System.out.println(" initialize browser ");
		eb.selectSearchCategories("Books");
		// System.out.println("Select books in search item");
		eb.searchItem("Steve Jobs");
		eb.searchButton();
		// Assert.assertEquals(eb.searchButtonText(), "Seerch");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		softAssert.assertTrue(eb.searchButtonText().equals("Seerch"), "assertion failed");
		softAssert.assertEquals(eb.searchButtonText(), "Seerch", " soft assert failed");

		eb.searchItem("Iphone");
		eb.searchItem("Mamo");
		//eb.closeBrowser();

	}
	
	@AfterTest
	public void tearDown() {
		
		eb.closeBrowser();
		
	}

}
