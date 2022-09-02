package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
	
	String offerPageProductName;
	TestContextSetup testContextSetup;
	
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	
	@Then("^User searched the (.+) Shortname in offers page$")
	public void user_searched_the_same_shortname_in_offers_page(String shortName) throws InterruptedException { 
	    
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		
	    Thread.sleep(2000);
	    offerPageProductName = offersPage.getProductName();
	    
	}
	
	public void switchToOffersPage() {
		//if switched to offers page -> skip this 
		//testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		
	    testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	
	@And("^Validate product name in offers page matches with landing page$")
	public void Validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName,this.testContextSetup.LandingPageProductName);
	}
}
