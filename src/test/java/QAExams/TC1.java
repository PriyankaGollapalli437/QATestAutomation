package QAExams;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import QAExams.PageObjects.HomePage;
import QAExams.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC1 extends BaseTest{

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
		
	}


