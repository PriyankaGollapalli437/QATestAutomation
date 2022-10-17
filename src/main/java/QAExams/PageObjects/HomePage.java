package QAExams.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import QAExams.AbstractComponents.AbstractComponents;




public class HomePage extends AbstractComponents {
		
	
		public HomePage(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		
		//Pagefactory
		

		@FindBy(css="select[class*='nav-search-dropdown']")
		WebElement dropdown;
		
		@FindBy (xpath= "//input[@name='field-keywords']")
		WebElement Searchbox;
		
		@FindBy (css= "span[class='a-dropdown-container'] span[class='a-button-inner']")
		WebElement Sortdropdown;
		
		
		@FindBy (css= "div[class='a-popover-inner'] li[role='option']:nth-child(2)")
		WebElement LowtoHigh;
		
		@FindBy (css= "div[class='a-popover-inner'] li[role='option']:nth-child(3)")
		WebElement HightoLow;
			
		
		@FindBy (xpath= "//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Belkin']")
		WebElement BrandBelkin;
		
		@FindBy (css= "input[placeholder='Min']")
		WebElement MinField;
		
		
		@FindBy (css= "input[placeholder='Max']")
		WebElement MaxField;
		
		@FindBy (css= "span[class='a-button-inner'] input[type='submit']")
		WebElement GoButton;
		
		@FindBy (css= ".a-price-whole")
		List<WebElement> getPrice;
		
		@FindBy (css= "img[class='s-image']")
		List<WebElement> selectproduct;
		
		@FindBy(css="li[id='p_36/1253506011'] span[class*='a-size-base']")
		WebElement selectpricerange;
		
		@FindBy(css=".s-pagination-next")
		WebElement next;
		
	
		
		public void SearchiPhone14(String category, String product)
		{

		Select selects = new Select(dropdown);
		selects.getOptions().stream().filter(cat-> cat.getText().contains(category)).findFirst().get().click();
		WebElement e = Searchbox;
		e.sendKeys(product);
		e.sendKeys(Keys.RETURN);
		}
		
		public void ValidatePriceRange(String minprice, String maxprice)
		{
		Sortdropdown.click();
		LowtoHigh.click();
        BrandBelkin.click();
        MinField.sendKeys(minprice);
        MaxField.sendKeys(maxprice);
        GoButton.click();
		
		List<WebElement> Items = getPrice;
		for (WebElement webElement : Items) {
            String Price = webElement.getText();
            int s = Integer.parseInt(Price);
            
            if(s>=100 && s<=2000)
            {
            	System.out.println("All in Range");
            	
            
            }
          else
          {
        	  System.out.println("Not in Range"+s);
          }
		}}
            
		 public void goTo()
	     {
	     	driver.get("https://www.amazon.com");
	     }
	     
		 public CheckoutPage SelectProduct()
		 {
			
			selectpricerange.click();
			implicitWait();
			List<WebElement> result = selectproduct;
			result.get(0).click();
			CheckoutPage checkout = new CheckoutPage(driver);
			return checkout;	
		 }
		
		 public void SortDesc()
		 {
				
			 selectpricerange.click();
			implicitWait();
			Sortdropdown.click();
			HightoLow.click();
				
			List<WebElement> Prices = getPrice;
			List<String> Items = new ArrayList<String>();
				
				for(WebElement p : Prices) {
					Items.add(p.getText());
				}
				
				implicitWait();
				String NextButton = next.getAttribute("class");
				
				
				while(!NextButton.contains("disabled"))
				{
					
					next.click();
				    implicitWait();
					Prices = getPrice;
					
					for(WebElement p : Prices)
					{
						Items.add(p.getText());
						
					}
					NextButton = next.getAttribute("class");
				}
					
					
				
				List<Integer> Numbers = new ArrayList<Integer>(Items.size());
				for(String current:Items){
				  Numbers.add(Integer.parseInt(current));
				}
				
				
				//System.out.println(Numbers);
				
				System.out.println(Numbers.size());
				for(int j=0; j<=Numbers.size()-1; j++)
				{
					//System.out.println(Numbers.indexOf(i));
					
				if(Numbers.get(j)>=Numbers.get(j+1)) {
				
				
					System.out.println("Descending order");
				
				}
				else
					
				{
					System.out.println("Not in Descending order");
					
				}
			}
				
		}
		
}
	
        

