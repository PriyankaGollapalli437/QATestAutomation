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

import QAExams.PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String category = "Electronics";
		String product = "iPhone 14";
		String minprice = "100";
		String maxprice = "2000";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select selects = new Select(driver.findElement(By.cssSelector("select[class*='nav-search-dropdown']")));
		selects.getOptions().stream().filter(cat-> cat.getText().contains(category)).findFirst().get().click();
		WebElement e = driver.findElement(By.xpath("//input[@name='field-keywords']"));
		e.sendKeys(product);
		e.sendKeys(Keys.RETURN);
		driver.findElement(By.cssSelector("span[class='a-dropdown-container'] span[class='a-button-inner']")).click();
		driver.findElement(By.cssSelector("div[class='a-popover-inner'] li[role='option']:nth-child(2)")).click();
	
		driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Belkin']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Min']")).sendKeys(minprice);
		driver.findElement(By.cssSelector("input[placeholder='Max']")).sendKeys(maxprice);
		driver.findElement(By.cssSelector("span[class='a-button-inner'] input[type='submit']")).click();
		
		List<WebElement> Items = driver.findElements(By.cssSelector(".a-price-whole"));
		for (WebElement webElement : Items) {
            String Price = webElement.getText();
            int s = Integer.parseInt(Price);
            
            if(s>=100 && s<=2000)
            {
            	Assert.assertTrue(true);
            
            }
          else
          {
        	  System.out.println("Not in Range"+s);
          }
		
	
	}}}


	


