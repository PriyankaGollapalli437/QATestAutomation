package QAExams;

import org.testng.Assert;
import org.testng.annotations.Test;

import QAExams.PageObjects.CheckoutPage;
import QAExams.PageObjects.HomePage;
import QAExams.testComponents.BaseTest;

public class TC3 extends BaseTest {

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
