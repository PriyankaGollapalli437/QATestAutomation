package QAExams.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import QAExams.AbstractComponents.AbstractComponents;

public class CheckoutPage  extends AbstractComponents {
	
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Pagefactory
	
	

	@FindBy(css="span[id='submit.add-to-cart']")
	WebElement addtocart;
	
	@FindBy(css="span[id='sw-gtc']")
	WebElement gotocart;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement proceedtocheckout;
	

	@FindBy(xpath="//h1[@class='a-spacing-small'][1]")
	WebElement SignInText;
	
	
	public void ValidateSignIn()
	{
		addtocart.click();
		gotocart.click();
		proceedtocheckout.click();
		SignInText.isDisplayed();
		
		
		
	}


}
