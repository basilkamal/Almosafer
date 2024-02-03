package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends parameters {

	@BeforeTest
	public void aaaa() {

		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement popUPScreen = driver.findElement(By.className("sc-iBmynh"));
		if (popUPScreen.isDisplayed()) {

			WebElement sarButtpn = driver.findElement(By.className("cta__saudi"));
			sarButtpn.click();
		}
	}

	@Test(priority = 1,enabled = false)
	public void checkTheDefultLanguge() {
		
		String expectedLanguge = "EN";
		String actuleLanguge = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		assertEquals(actuleLanguge, expectedLanguge);

	}
	
	@Test(priority = 2,enabled = false)
	public void checkTheDefultLCurancy() {
		
		
		String expectedCurancy = "SAR";
		String actuleCurancy = driver.findElement(By.className("sc-dRFtgE")).getText();
		assertEquals(actuleCurancy, expectedCurancy);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void checkThecontactNumber() {
		
		
		String expectedContact= "+966554400000";
		String actulecontact = driver.findElement(By.tagName("strong")).getText();
		assertEquals(actulecontact, expectedContact);
		
	}
	
	@Test(priority = 4,enabled = false)
	public void checkTheQetafLogo() {
		
		
		WebElement Footer = driver.findElement(By.tagName("footer"));
		Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
		assertEquals(Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(), true);
		
	}
	
	@Test(priority = 5 ,enabled = false)
	public void checkTheHoteltabIsNotSelectedByDefult() {
		
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
		//System.out.println(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"));
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"), "false");
		
	}
	@Test(priority = 7 )
	public void randomMethodToChangeTheLanguge() {
		Random rand = new Random();
		int randomindexForTheWebsite = rand.nextInt(website.length);
		driver.get(website[randomindexForTheWebsite]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			
			String expectedLang = "ar";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals( actualLang, expectedLang);
			
		}
		else {
			String expectedLang = "en";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals( actualLang, expectedLang);
		}
		
		
		
		
		
	}
	
	

	@AfterTest
	public void cccc() {

	}

}
