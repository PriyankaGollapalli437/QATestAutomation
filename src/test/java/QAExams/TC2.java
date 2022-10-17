package QAExams;

import org.testng.annotations.Test;

import QAExams.PageObjects.HomePage;
import QAExams.testComponents.BaseTest;

public class TC2 extends BaseTest {

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
	
	
	
}
