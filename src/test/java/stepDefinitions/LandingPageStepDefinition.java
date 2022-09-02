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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	
	@Given("^User is on GreenKart landing page$")
	public void user_is_on_greenkart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	    
	}
	
	
	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		
		landingPage.searchItem(shortName);
		
		Thread.sleep(2000);
		testContextSetup.LandingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.LandingPageProductName + " is extracted from home page");
	}
	
	//@And
	@And("^added \"([^\"]*)\" items of the selected products to cart$")
    public void added_something_items_of_the_selected_products_to_cart(String strArg1) throws Throwable {
        int quantity = Integer.parseInt(strArg1);
        landingPage.incrementQuantity(quantity);
        landingPage.AddToCart();
    }

	
}
