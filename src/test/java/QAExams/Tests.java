package QAExams;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import QAExams.PageObjects.CheckoutPage;
import QAExams.PageObjects.HomePage;
import QAExams.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tests extends BaseTest{


	@Test
	public void Testcase1()
	{
		String category = "Electronics";
		String product = "iPhone 14";
		String minprice = "100";
		String maxprice = "2000";
		
		HomePage Homepage = new HomePage(driver);
		Homepage.goTo();
		Homepage.SearchiPhone14(category, product);
		Homepage.ValidatePriceRange(minprice, maxprice);
	}
	
	

	@Test
	public void Testcase2()
	{
		String category = "Electronics";
		String product = "iPhone 14";
		HomePage Homepage = new HomePage(driver);
		Homepage.goTo();
		Homepage.SearchiPhone14(category, product);
		Homepage.SortDesc();
		
	}
	
	
	@Test
	public void Testcase3()
	{
		String category = "Electronics";
		String product = "iPhone 14";
		HomePage Homepage = new HomePage(driver);
		Homepage.goTo();
		Homepage.SearchiPhone14(category, product);
		CheckoutPage checkout = Homepage.SelectProduct();
		checkout.ValidateSignIn();
		Assert.assertTrue(true);

	}
	}
